package com.wheat.algorithm.base.matrix;

import java.util.*;

/**
 * @author maij
 * @description:
 * @date 2024-08-16 14:50
 **/
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(courseSchedule.canFinish(5, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = prerequisiteMap.get(prerequisite[1]);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(prerequisite[0]);
            prerequisiteMap.put(prerequisite[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int n = numCourses;
        while (queue.size() > 0) {
            n--;
            List<Integer> courses = prerequisiteMap.get(queue.poll());
            if (courses == null || courses.size() == 0) {
                continue;
            }
            for (Integer c : courses) {
                inDegree[c]--;
                if (inDegree[c] == 0) {
                    queue.add(c);
                }
            }
        }
        return n == 0;
    }

}
