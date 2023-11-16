/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Manager.controller;

import dal.ManagerDAO;
import dal.QuizDAO;
import dal.SubjectDAO;
import dal.SubjectSettingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;
import model.Quiz;
import model.Subject;
import model.SubjectSetting;
import model.User;

/**
 *
 * @author MinhDQ
 */
public class Quizs extends HttpServlet {

    QuizDAO qd = new QuizDAO();
    SubjectDAO sd = new SubjectDAO();
    SubjectSettingDAO ssd = new SubjectSettingDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action") == null ? "list" : request.getParameter("action");
            switch (action) {
                case "list":
                    quizList(request, response);
                    break;
                case "search":
                    searchQuiz(request, response);
                    break;
                case "detailQuiz":
                    String quizID = request.getParameter("quizID");
                    detailQuiz(request, response, quizID);
                    break;
                case "sort":
                    sort(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    quizList(request, response);
                    break;
                case "removeQuestion":
                    removeQuestion(request, response);
                    break;
                case "addQuiz":
                    addQuiz(request, response);
                    break;
                case "activeAndDeactive":
                    activeAndDeactivedQuiz(request, response);
                    quizList(request, response);
                    break;
                case "updateQuiz":
                    updateQuiz(request, response);
                    break;
                case "addQuestionToQuiz":
                    addQuestionToQuiz(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void quizList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Quiz> quizList = qd.getAllQuizzes();
        int numOfSubject = quizList.size();
        int page, startPage = 1, endPage;
        int maxPage = numOfSubject / 10;
        if (numOfSubject % 10 != 0) {
            maxPage++;
        }
        String spage = request.getParameter("page");
        if (spage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(spage);
        }
        int start, end;
        start = (page - 1) * 10;
        end = Math.min(page * 10, numOfSubject);
        ArrayList<Quiz> listByPage = qd.getQuizByPage(quizList, start, end);

        if (page >= 3) {
            if (page + 2 < maxPage) {
                endPage = page + 2;
            } else {
                endPage = maxPage;
            }
            if (maxPage >= 5) {
                startPage = endPage - 4;
            } else {
                startPage = page - 2;
            }
        } else {
            if (maxPage >= 5) {
                endPage = 5;
            } else {
                endPage = maxPage;
            }
        }
        ArrayList<Subject> subjectList = sd.getAllSubjects();
        ArrayList<SubjectSetting> chapterList = ssd.getAllChapters();
        request.setAttribute("nasc", 0);
        request.setAttribute("sasc", 0);
        request.setAttribute("casc", 0);
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("quizList", listByPage);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("chapterList", chapterList);
        request.getRequestDispatcher("quizList.jsp").forward(request, response);
    }

    private void searchQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchContent = request.getParameter("searchContent");
        String subject = request.getParameter("searchBySubject");
        String chapter = request.getParameter("searchByChapter");
        ArrayList<Quiz> quizList = qd.searchQuiz(searchContent, subject, chapter);
        ArrayList<Subject> subjectList = sd.getAllSubjects();
        ArrayList<SubjectSetting> chapterList = ssd.getAllChapters();
        request.setAttribute("page", 1);
        request.setAttribute("startPage", 1);
        request.setAttribute("endPage", 1);
        request.setAttribute("maxPage", 1);
        request.setAttribute("searchContent", searchContent);
        request.setAttribute("searchBySubject", subject);
        request.setAttribute("searchByChapter", chapter);
        request.setAttribute("quizList", quizList);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("chapterList", chapterList);
        request.getRequestDispatcher("quizList.jsp").forward(request, response);
    }

    private void addQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        int chapterId = Integer.parseInt(request.getParameter("chapter"));
        String name = request.getParameter("name");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        boolean type = Boolean.parseBoolean(request.getParameter("type"));
        int numberOfQuestion = Integer.parseInt(request.getParameter("total"));
        int quizTime = Integer.parseInt(request.getParameter("time"));
        Date uDate = new Date();
        Timestamp timestamp = new Timestamp(uDate.getTime());
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userID = user.getUserId();
        Quiz quiz = new Quiz(name, subjectId, chapterId, type, numberOfQuestion, status, quizTime, timestamp, userID, timestamp, userID);
        qd.addQuiz(quiz);
        request.setAttribute("txt", "Success");
        request.getRequestDispatcher("quizs?action=list").forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        String type = request.getParameter("type");
        String nasc = request.getParameter("nasc");
        String sasc = request.getParameter("sasc");
        String casc = request.getParameter("casc");
        ArrayList<Quiz> quizList = qd.getAllQuizzes();
        int numOfSubject = quizList.size();
        int startPage = 1, endPage;
        int maxPage = numOfSubject / 10;
        if (numOfSubject % 10 != 0) {
            maxPage++;
        }
        int start, end;
        start = (page - 1) * 10;
        end = Math.min(page * 10, numOfSubject);
        ArrayList<Quiz> listByPage = new ArrayList();
        if ("name".equals(type)) {
            listByPage = sortByComponent(qd.getQuizByPage(quizList, start, end), type, nasc);
            if ("0".equals(nasc)) {
                request.setAttribute("nasc", 1);
            } else {
                request.setAttribute("nasc", "0");
            }
            request.setAttribute("sasc", sasc);
            request.setAttribute("casc", casc);
        } else if ("subject".equals(type)) {
            listByPage = sortByComponent(qd.getQuizByPage(quizList, start, end), type, sasc);
            if ("0".equals(sasc)) {
                request.setAttribute("sasc", 1);
            } else {
                request.setAttribute("sasc", "0");
            }
            request.setAttribute("casc", casc);
            request.setAttribute("nasc", nasc);
        } else {
            listByPage = sortByComponent(qd.getQuizByPage(quizList, start, end), type, casc);
            if ("0".equals(casc)) {
                request.setAttribute("casc", 1);
            } else {
                request.setAttribute("casc", "0");
            }
            request.setAttribute("nasc", nasc);
            request.setAttribute("sasc", sasc);
        }
        if (page >= 3) {
            if (page + 2 < maxPage) {
                endPage = page + 2;
            } else {
                endPage = maxPage;
            }
            if (maxPage >= 5) {
                startPage = endPage - 4;
            } else {
                startPage = page - 2;
            }
        } else {
            if (maxPage >= 5) {
                endPage = 5;
            } else {
                endPage = maxPage;
            }
        }
        ArrayList<Subject> subjectList = sd.getAllSubjects();
        ArrayList<SubjectSetting> chapterList = ssd.getAllChapters();
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("quizList", listByPage);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("chapterList", chapterList);
        request.getRequestDispatcher("quizList.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quizID = request.getParameter("quizID");
        String page = request.getParameter("page");
        qd.deleteQuizByID(quizID);
        request.setAttribute("page", page);
        request.setAttribute("txt", "Success");
    }

    private ArrayList<Quiz> sortByComponent(ArrayList<Quiz> quizByPage, String type, String asc) {
        if ("name".equals(type)) {
            if ("0".equals(asc)) {
                Collections.sort(quizByPage, new Comparator<Quiz>() {
                    @Override
                    public int compare(Quiz o1, Quiz o2) {
                        return o1.getQuizName().compareTo(o2.getQuizName());
                    }
                });
            } else {
                Collections.sort(quizByPage, new Comparator<Quiz>() {
                    @Override
                    public int compare(Quiz o1, Quiz o2) {
                        return o2.getQuizName().compareTo(o1.getQuizName());
                    }
                });
            }
        } else if ("subject".equals(type)) {
            if ("0".equals(asc)) {
                Collections.sort(quizByPage, new Comparator<Quiz>() {
                    @Override
                    public int compare(Quiz o1, Quiz o2) {
                        return o1.getS().getSubjectId() - o2.getS().getSubjectId();
                    }
                });
            } else {
                Collections.sort(quizByPage, new Comparator<Quiz>() {
                    @Override
                    public int compare(Quiz o1, Quiz o2) {
                        return o2.getS().getSubjectId() - o1.getS().getSubjectId();
                    }
                });
            }
        } else {
            if ("0".equals(asc)) {
                Collections.sort(quizByPage, new Comparator<Quiz>() {
                    @Override
                    public int compare(Quiz o1, Quiz o2) {
                        return o1.getSs().getSettingId() - o2.getSs().getSettingId();
                    }
                });
            } else {
                Collections.sort(quizByPage, new Comparator<Quiz>() {
                    @Override
                    public int compare(Quiz o1, Quiz o2) {
                        return o2.getSs().getSettingId() - o1.getSs().getSettingId();
                    }
                });
            }
        }
        return quizByPage;
    }

    private void activeAndDeactivedQuiz(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String id = request.getParameter("quizID");
        Quiz quiz = qd.getQuiz("q.quiz_id", id);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userID = 0;
        if (user != null) {
            userID = user.getUserId();
        }
        quiz.setUpdateBy(userID);
        if (quiz.isStatus() == true) {
            quiz.setStatus(false);
            qd.activeAndDeactive(quiz);
        } else {
            quiz.setStatus(true);
            qd.activeAndDeactive(quiz);
        }
        request.setAttribute("page", page);
        request.setAttribute("txt", "Success");
    }

    private void detailQuiz(HttpServletRequest request, HttpServletResponse response, String quizID) throws ServletException, IOException {
        Quiz quiz = qd.getQuiz("quiz_id", quizID);
        ArrayList<Question> questionList = qd.getQuestionsByQuiz(quizID);
        ArrayList<Question> questionListToAdd = qd.getQuestionToAdd(quiz);
        ManagerDAO Sdao = new ManagerDAO();
        SubjectSettingDAO ssdao = new SubjectSettingDAO();
        System.out.println(quiz.getSubjectId());
        List<SubjectSetting> listC = Sdao.getChapterbySubject(quiz.getS().getSubjectId());
        List<SubjectSetting> listss = ssdao.getDimentionBySubjectId(quiz.getS().getSubjectId());
        request.setAttribute("listss", listss);
        request.setAttribute("listC", listC);
        request.setAttribute("quiz", quiz);
        request.setAttribute("creater", sd.getManagerName(quiz.getCreateBy() + ""));
        request.setAttribute("updater", sd.getManagerName(quiz.getUpdateBy() + ""));
        request.setAttribute("subjectname", qd.getSubjectName(quiz.getS().getSubjectId() + ""));
        request.setAttribute("chaptername", qd.getChapterName(quiz.getSs().getSettingId() + ""));
        request.setAttribute("questionList", questionList);
        request.setAttribute("questionListToAdd", questionListToAdd);
        request.getRequestDispatcher("quizDetail.jsp").forward(request, response);
    }

    private void removeQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quizID = request.getParameter("quizID");
        String quesId = request.getParameter("quesID");
        qd.deleteQuesByID(quesId, quizID);
        qd.updateTotal(quizID);
        request.setAttribute("txt", "Success");
        request.getRequestDispatcher("quizs?action=detailQuiz&quizID=" + quizID).forward(request, response);
    }

    private void updateQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quizID = request.getParameter("quizID");
        String name = request.getParameter("name");
        int total = Integer.parseInt(request.getParameter("total"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userID = 0;
        if (user != null) {
            userID = user.getUserId();
        }
        Quiz quiz = qd.getQuiz("quiz_id", quizID);
        quiz.setQuizName(name);
        quiz.setNumberQuestion(total);
        quiz.setUpdateBy(userID);
        qd.updateQuiz(quiz);
        request.setAttribute("txt", "Success");
        request.getRequestDispatcher("quizs?action=detailQuiz&quizID=" + quizID).forward(request, response);

    }

    private void addQuestionToQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String quizID = request.getParameter("quizID");
        String str = request.getParameter("questionIdToAdd");
        boolean type = Boolean.parseBoolean(request.getParameter("type"));
        int inttype = type ? 1 : 0;
        if (str.length() != 0) {
            String[] strArray = str.split(",");
            ArrayList<Integer> listQuestionId = new ArrayList<>();
            for (String numStr : strArray) {
                listQuestionId.add(Integer.parseInt(numStr));
            }
            qd.addQuestionToQuiz(quizID, listQuestionId, inttype);
        }
        request.setAttribute("txt", "Success");
        request.getRequestDispatcher("quizs?action=detailQuiz&quizID=" + quizID).forward(request, response);
    }

    private ArrayList<Integer> generateRandom(Quiz quiz) {
        ArrayList<Integer> listQuestion = qd.geAllQuestionIdByChapterSubject(quiz);

        int[] listRandomNumbers = generateRandomNumbers(quiz.getNumberQuestion(), 0, listQuestion.size() - 1);

        ArrayList<Integer> listQuestionId = new ArrayList<>();

        for (int i = 0; i < listRandomNumbers.length; i++) {
            listQuestionId.add(listQuestion.get(listRandomNumbers[i]));
//                System.out.println(listQuestion.get(i));
        }

        return listQuestionId;
    }

    public int[] generateRandomNumbers(int count, int min, int max) {
        if (count > (max - min + 1)) {
            throw new IllegalArgumentException("Number of random numbers exceeds the range.");
        }

        // Tạo mảng ban đầu chứa các số từ min đến max
        int[] initialArray = new int[max - min + 1];
        for (int i = min; i <= max; i++) {
            initialArray[i - min] = i;
        }

        // Trộn lẫn thứ tự các số trong mảng
        Random random = new Random();
        for (int i = initialArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = initialArray[i];
            initialArray[i] = initialArray[j];
            initialArray[j] = temp;
        }

        // Chọn ? số đầu tiên và sắp xếp lại mảng
        int[] randomNumbers = Arrays.copyOf(initialArray, count);
        Arrays.sort(randomNumbers);
        return randomNumbers;
    }
}
