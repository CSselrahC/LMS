User class
- id : String
- lastName : String
- firstName : String
- password : String
- userType : String

Admin class extends User
- accountManager : AccountManager
- courseManager : CourseManager
+ createUser(userType : String) : void
+ deleteUser(userType : String) : void
+ changePasswordOf(userType : String) : void
+ createCourse() : void
+ deleteCourse(course : Course) : void
+ assignInstructorAt(course : Course) : void
+ generateReport() : void

Instructor class extends User
- handledCourses : List<Course>
+ addContentTo(course : Course) : void

Student class extends User
- profile : Profile
- enrolledCourses : List<Course>
+ editProfile() : void
+ enrollCourse() : void
+ submitActivity() : void

Profile class composition Student
- studentNumber : String
- sexAtBirth : String
- civilStatus : String
- residency : String
- nationality : String
- religion : String
- dateOfBirth : String
- placeOfBirth : String

Course class
- code : String
- title : String
- contents : List<Content>
- activities : List<Activity>
- students : List<Student>
- instructor : Instructor
+ enrollStudent(student : Student) : void
+ dropStudent(student : Student) : void
+ createActivity() : void
+ deleteActivity(activity : Activity) : void

Activity class composition Course
- name : String
- description : String
- type : String
- submitted : boolean
- datePosted : String
- dateSubmitted : String
- dateDue : String
- course : Course

Content class
- id : String
- title : String
- type : String
- file : File
- course : Course
+ displayContent() : void


AccountManager class
- studentList : List<Student>
- instructorList : List<Instructor>
- admin : Admin
- loggedInAccount : User
+ initializeUsers() : void (pang initialize lang ng mga dummy data, not a core function)
+ addStudentAccount(student : Student) : void
+ addInstructorAccount(instructor : Instructor) : void
+ removeStudentAccount(student : Student) : void
+ removeInstructorAccount(instructor : Instructor) : void
+ loginPageSelector(userType : String) : void
+ logout() : void

CourseManager class
- instance : CourseManager (static)
- courses : List<Course>
- accountManager : AccountManager
+ initializeCourses : void (pang initialize lang ng mga dummy data, not a core function)
+ initializeEnrolledStudents : void (pang initialize lang ng mga dummy data, not a core function)
+ addCourse(course : Course) : void
+ removeCourse(course : Course) : void

