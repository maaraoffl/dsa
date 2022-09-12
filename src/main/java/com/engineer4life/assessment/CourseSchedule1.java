package com.engineer4life.assessment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class CourseSchedule1 {

    static class Course {
        int id;
        Set<Course> prerequisites;

        Course(int id){
            this.id = id;
            this.prerequisites = new HashSet<Course>();
        }

        Course(int id, Set<Course> prerequistes){
            this.id = id;
            this.prerequisites = prerequistes;
        }

        void addPrerequisite(Course course){
            this.prerequisites.add(course);
        }
    }

    static class CurriculumEvaluator {
        int numCourse;
        Map<Integer, Course> courseById = new HashMap<>();
        Set<Course> visiting = new HashSet<>();

        // Memoizing evaluated dependencies
        // otherwise takes more time and possibly time limit exceed
        Set<Course> visited = new HashSet<>();

        CurriculumEvaluator(int num){
            this.numCourse = num;
            initializeCourses();
        }

        void digestPrerequistes(int[][] prerequisites){
            for(var prerequisite : prerequisites){
                var course = courseById.get(prerequisite[0]);
                var dependency = courseById.get(prerequisite[1]);
                course.addPrerequisite(dependency);
            }
        }

        boolean canFinish(Course course){
            if(visited.contains(course)) return true;
            if(!visiting.contains(course)){
                visiting.add(course);
                for(Course dependency: course.prerequisites){
                    if(!canFinish(dependency)) return false;
                }

                visited.add(course);
                visiting.remove(course);

                return true;
            } else return false;
        }

        private void initializeCourses(){
            for(var i=0; i < numCourse; i++){
                courseById.put(i, new Course(i));
            }
        }

    }

    // Time limit exceeded for recursion solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var evaluator = new CurriculumEvaluator(numCourses);
        evaluator.digestPrerequistes(prerequisites);

        for(int courseId : evaluator.courseById.keySet()){
            var course = evaluator.courseById.get(courseId);
            if(!evaluator.canFinish(course)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var problem = new CourseSchedule1();
        boolean result = problem.canFinish(2, new int[][]{{1,0}});
        System.out.println(result);
    }
}
