package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;

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
        Instructor theInstructor = entityManager.find(Instructor.class, theId);

        // delete the instructor
        entityManager.remove(theInstructor);
    }
}
