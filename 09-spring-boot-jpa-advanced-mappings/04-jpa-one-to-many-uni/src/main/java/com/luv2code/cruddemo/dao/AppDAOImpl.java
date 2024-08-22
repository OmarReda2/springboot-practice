package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transcational
    public void update(Instructor instructor){
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse){
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId){
        return entityManager.find(Course.class, theId);
    }


    @Override
    public Instructor findInstructorByJoinFetch(int theId){

        // create query
        TypedQuery<Instructor> query = entityManager.createQuery( "SELECT i FROM Instructor "
                                                                + "JOIN FETCH i.courses "
                                                                + "JOIN FETCH i.instructorDetail"
                                                                + "WHERE i.id =: data", Instructor.class);

        // execute the query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }


    @Override
    public List<Course> findCoursesByInstructorId (int theId){

        // create query
        TypedQuery query = entityManager.createQuery(
                                            "FROM Course WHERE Instructor.id =: data", Course.class);
        query.setParameter("data", theId);

        // execute query
        List<Course> courses = query.getResultList();

        return Courses;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId){

        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete instructor detail
        entityManager.remove(tempInstructorDetail);

    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id){
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId){

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get the course
        List<Course> courses = tempInstructor.getCourses();

        // delete associated of all courses for the instructor
        for (Course tempCourse: courses){
            tempCourse.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId){
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId){

        // retrieve course
        Course tempCourse = entityManager.find(Course.class, theId);

        // delete the course
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course course){
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int theId){

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                    "SELECT c FROM Course c " +
                    "JOIN FETCH c.reviews " +
                    "WHERE c.id =: data", Course.class);

        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;

    }
}
