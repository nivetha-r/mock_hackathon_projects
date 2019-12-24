

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.entity.CourseEnrollment;
import com.hcl.training.repository.EnrollCourseRepository;
import com.hcl.training.util.ExceptionConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ajith
 * @desc This service will take care of all transaction from account to mortgage
 *       account
 *
 */
@Service
@Slf4j
@Transactional
public class SchedulerServiceImpl implements SchedulerService {

	@Autowired
	private EnrollCourseRepository enrollCourseRepository;

	@Autowired
	private ExceptionConstants exceptionConstants;

	@Override
	public void runTask() {

		log.info("SchedulerServiceImpl :: runTask - starts");

		List<CourseEnrollment> updateenrolledcourses = new ArrayList<>();
		List<CourseEnrollment> enrolledcourses = enrollCourseRepository.findByEnrollmentStatusAndDaysLeft();
		enrolledcourses.stream().forEach(enrolledCourse -> {

			Integer daysLeft = enrolledCourse.getDaysLeft();

			if (daysLeft > 0) {
				daysLeft--;
				log.info("DaysLeft={}", daysLeft);
				enrolledCourse.setDaysLeft(daysLeft);
				updateenrolledcourses.add(enrolledCourse);
				if (daysLeft == 0) {

					CourseEnrollment requestedCourse = enrollCourseRepository
							.findByEnrollmentStatusAndCourseId(enrolledCourse.getCourseId());

					log.info("EnrolledDate={}", requestedCourse.getEnrolledDate());
					requestedCourse.setEnrollmentStatus(ExceptionConstants.ENROLL_COURSE_STATUS_ENROLLED);
					enrollCourseRepository.save(requestedCourse);
					
					
					enrolledCourse.setEnrollmentStatus(ExceptionConstants.ENROLL_COURSE_STATUS_SUBMITTED);
					updateenrolledcourses.add(enrolledCourse);
				}
			}

			log.info("SchedulerServiceImpl :: runTask - enrolledCourse : ");

		});

		enrollCourseRepository.saveAll(updateenrolledcourses);
		log.info("SchedulerServiceImpl :: runTask - END");
	}
}
