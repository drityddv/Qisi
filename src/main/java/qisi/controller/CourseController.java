package qisi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qisi.bean.course.*;
import qisi.exception.courseException.CourseNotExistException;
import qisi.service.CourseService;
import qisi.utils.Utils;

import java.util.Date;
import java.util.List;

/**
 * @author : ddv
 * @date : 2018/10/29 下午1:25
 */

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;


	/**
	 * 查询所有课程
	 */
	@ResponseBody
	@GetMapping("/courses")
	public List<Course> findAllCourses() {
		return courseService.findAllCourses();
	}

	/**
	 * courseName
	 * 按课程名获取课程信息
	 */
	@ResponseBody
	@GetMapping("/course")
	public Course findCourseByName(@RequestParam("courseName") String courseName) {
		return courseService.findCourseByName(courseName);
	}

	/**
	 * courseId
	 * 按课程ID获取课程信息
	 */
	@ResponseBody
	@GetMapping("/course/{courseId}")
	public Course findCourseByCourseId(@PathVariable("courseId") String courseId) {
		return courseService.findCourseByCourseId(courseId);
	}


	/**
	 * courseId
	 * 按课程ID获取该课程下的所有目录
	 */
	@ResponseBody
	@GetMapping("/course/{courseId}/chapters")
	public List<Chapter> findChaptersByCourseId(@PathVariable String courseId) {
		List<Chapter> chapters = courseService.findChaptersByCourseId(courseId);
		return chapters;
	}

	/**
	 * lessonId
	 * 查询某节课对应的所有task
	 */
	@ResponseBody
	@GetMapping("/lesson/{lessonId}")
	public List<Task> findExercisesByLessonId(@PathVariable String lessonId) {
		List<Task> tasks = courseService.findTasksByLessonId(lessonId);
		return tasks;
	}


	/**
	 * 获取所有训练信息
	 */
	@ResponseBody
	@GetMapping("/tasks")
	public List<Task> findTasks() {
		return courseService.findTasks();
	}

	/**
	 * 根据训练ID获取训练信息
	 */
	@ResponseBody
	@GetMapping("/task/{taskId}")
	public Task findExerciseByExercise(@PathVariable("taskId") String taskId) {
		return courseService.findTaskByTaskId(taskId);
	}

	/**
	 * 提交代码
	 *
	 * @param code
	 * @param exerciseId
	 * @return
	 */
	@ResponseBody
	@PostMapping("/code/{exerciseId}")
	public String commitCode(@RequestBody Code code, @PathVariable String exerciseId) {
		code.setTaskId(exerciseId);
		code.setCodeId(Utils.getUUID());
		code.setCreatedAt(new Date());
		courseService.saveCode(code);
		return "保存完毕!";
	}


}
