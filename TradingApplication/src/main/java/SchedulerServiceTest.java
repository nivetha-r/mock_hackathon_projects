


import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.training.entity.CourseEnrollment;
import com.hcl.training.repository.EnrollCourseRepository;
import com.hcl.training.service.SchedulerServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchedulerServiceTest {

	@Mock
	private EnrollCourseRepository enrollCourseRepository;

	@InjectMocks
	private SchedulerServiceImpl schedulerServiceImpl;

	List<CourseEnrollment> courseEnrolls = new ArrayList<>();
	List<CourseEnrollment> updateenrolledCourses = new ArrayList<>();

	@Test
	public void testRunTask() {

		CourseEnrollment courseEnrollment = new CourseEnrollment();
		courseEnrollment.setCourseId(1);
		courseEnrollment.setCourseName("Java Tutorials");
		courseEnrollment.setEnrolledDate(LocalDateTime.now());
		courseEnrollment.setEnrollmentId(1);
		courseEnrollment.setEnrollmentStatus("ENROLLED");
		courseEnrollment.setDaysLeft(5);
		courseEnrollment.setUserId(1);
		courseEnrolls.add(courseEnrollment);
		updateenrolledCourses.add(courseEnrollment);

		Mockito.when(enrollCourseRepository.findByEnrollmentStatusAndDaysLeft()).thenReturn(updateenrolledCourses);
		Mockito.when(enrollCourseRepository.findByEnrollmentStatusAndCourseId(Mockito.anyInt())).thenReturn(courseEnrollment);
		
		List<CourseEnrollment> response= enrollCourseRepository.findByEnrollmentStatusAndDaysLeft();
		assertEquals(updateenrolledCourses.size(), response.size());
		CourseEnrollment response2= enrollCourseRepository.findByEnrollmentStatusAndCourseId(Mockito.anyInt());
		assertEquals("Java Tutorials",response2.getCourseName());
	}
}
