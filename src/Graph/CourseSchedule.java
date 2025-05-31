package src.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println("courses can be taken: "+canFinish(numCourses, prerequisites));
    }

    /**
     * Determines if all courses can be finished given their prerequisites (no cycles in dependency graph).
     * Uses Kahn's Algorithm for topological sorting.
     *
     * @param n             Total number of courses (0 to n-1)
     * @param prerequisites Array of prerequisite pairs [course, prerequisite]
     * @return true if all courses can be completed, false otherwise
     */
    public static boolean canFinish(int n, int[][] prerequisites) {
        // Step 1: Initialize adjacency list to represent course dependencies
        // graph[i] will contain all courses that depend on course i
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Initialize in-degree array to track number of prerequisites per course
        // inDegree[i] = number of prerequisites course i requires
        int[] inDegree = new int[n];

        // Step 3: Build the dependency graph and populate in-degree counts
        for (int[] prereq : prerequisites) {
            int course = prereq[0];         // The course that has a prerequisite
            int prerequisite = prereq[1];   // The required prerequisite course

            // Add edge from prerequisite to dependent course
            graph[prerequisite].add(course);

            // Increment in-degree count for the dependent course
            inDegree[course]++;
        }

        // Step 4: Initialize queue with courses having no prerequisites (in-degree = 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);  // These courses can be taken immediately
            }
        }

        // Step 5: Process courses using BFS (Kahn's Algorithm)
        int completedCourses = 0;  // Tracks how many courses we've successfully taken

        while (!queue.isEmpty()) {
            // Take a course that has all its prerequisites met
            int currentCourse = queue.poll();
            completedCourses++;

            // For all courses that depend on the current course
            for (int dependentCourse : graph[currentCourse]) {
                // Reduce their in-degree count (since we've completed a prerequisite)
                inDegree[dependentCourse]--;

                // If all prerequisites are now met, add to queue
                if (inDegree[dependentCourse] == 0) {
                    queue.offer(dependentCourse);
                }
            }
        }

        // Step 6: Check if we completed all courses (no cycles)
        // If completedCourses == n, all courses were taken (no cycles)
        // Otherwise, there was a cycle preventing some courses from being taken
        return completedCourses == n;
    }
}
