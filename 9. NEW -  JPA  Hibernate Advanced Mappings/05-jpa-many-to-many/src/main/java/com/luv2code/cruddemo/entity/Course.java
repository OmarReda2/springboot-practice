package com.luv2code.cruddemo.entity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    // annotate the class as an entity and map to db table

    // define constructor

    // define getter setter

    // define toString

    // annotate fields

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @joinColumn(name="instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.Lazy, cascade = CascadeT.ALL)
    @joinColumn(name="course_id")
    public List<Review> reviews;

    @ManyToMany(fetch = FetchType.Lazy,
                cascade = {CascadeType.DETACH, CascadeType.PERSIST,
                           CascadeType.REFRESH, CascadeType.MERGE})
    @joinTable(
            name = "student_course",
            join_columns = @JoinColumn(name = "course_id"),
            inverseJoinColumn = @joinColumn(name = "student_id")
    )
    public List<Student> students;


    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // add a convenience method
    public void addReview(Review review){

        if(reviews == null){
            reviews = new ArrayList<>();
        }

        reviews.add(review);
    }


    public void add(Student student){

        if(student == null)
            student = new ArrayList<>();

        students.add(student);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
