/**
 * @Author: BrianHu
 * @Date: 2019/10/3
 * @Time: 9:53
 */
package pers.brian.hrm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.brian.hrm.dao.*;
import pers.brian.hrm.domain.*;
import pers.brian.hrm.service.HrmService;
import pers.brian.hrm.util.tag.PageModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private DocumentDao documentDao;

    @Transactional(readOnly = true)
    @Override
    public User login(String loginname, String password) {
        System.out.println("HrmServiceImpl login -- >>");
        return userDao.selectByLoginnameAndPassword(loginname, password);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findUser(User user, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        int recordCount = userDao.count(params);
        System.out.println("recordCount -- >>" + recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel", pageModel);
        }
        List<User> users = userDao.selectByPage(params);
        return users;
    }

    @Override
    public void removeUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.update(user);
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("employee", employee);
        int recordCount = employeeDao.count(params);
        System.out.println("recordCount -- >>" + recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel", pageModel);
        }
        List<Employee> employees = employeeDao.selectByPage(params);
        return employees;
    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.selectById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dept> findDept(Dept dept, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("dept", dept);
        int recordCount = deptDao.count(params);
        System.out.println("recordCount -- >>" + recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel", pageModel);
        }
        List<Dept> depts = deptDao.selectByPage(params);
        return depts;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }

    @Override
    public void removeDeptById(Integer id) {
        deptDao.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.save(dept);
    }

    @Transactional(readOnly = true)
    @Override
    public Dept findDeptById(Integer id) {
        return deptDao.selectById(id);
    }

    @Override
    public void modifyDept(Dept dept) {
        deptDao.update(dept);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Job> findAllJob() {
        return jobDao.selectAllJob();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Job> findJob(Job job, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("job", job);
        int recordCount = jobDao.count(params);
        System.out.println("recordCount -- >>" + recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel", pageModel);
        }
        List<Job> jobs = jobDao.selectByPage(params);
        return jobs;
    }

    @Override
    public void removeJobById(Integer id) {
        jobDao.deleteById(id);
    }

    @Override
    public void addJob(Job job) {
        jobDao.save(job);
    }

    @Transactional(readOnly = true)
    @Override
    public Job findJobById(Integer id) {
        return jobDao.selectById(id);
    }

    @Override
    public void modifyJob(Job job) {
        jobDao.update(job);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Notice> findNotice(Notice notice, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("notice", notice);
        int recordCount = noticeDao.count(params);
        System.out.println("recordCount -- >>" + recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel", pageModel);
        }
        List<Notice> notices = noticeDao.selectByPage(params);
        return notices;
    }

    @Transactional(readOnly = true)
    @Override
    public Notice findNoticeById(Integer id) {
        return noticeDao.selectById(id);
    }

    @Override
    public void removeNoticeById(Integer id) {
        noticeDao.deleteById(id);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeDao.save(notice);
    }

    @Override
    public void modifyNotice(Notice notice) {
        noticeDao.update(notice);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Document> findDocument(Document document, PageModel pageModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("document", document);
        int recordCount = noticeDao.count(params);
        System.out.println("recordCount -- >>" + recordCount);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel", pageModel);
        }
        List<Document> documents = documentDao.selectByPage(params);
        return documents;
    }

    @Override
    public void addDocument(Document document) {
        documentDao.save(document);
    }

    @Transactional(readOnly = true)
    @Override
    public Document findDocumentById(Integer id) {
        return documentDao.selectById(id);
    }

    @Override
    public void removeDocumentById(Integer id) {
        documentDao.deleteById(id);
    }

    @Override
    public void modifyDocument(Document document) {
        documentDao.update(document);
    }
}
