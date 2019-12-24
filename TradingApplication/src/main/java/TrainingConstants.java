

import org.springframework.stereotype.Component;

@Component
public class TrainingConstants {
	private TrainingConstants() {
		
	}

	public static final Integer SUCCESS_STATUS_CODE = 200;
	public static final String SUCCESS_STATUS_MESSAGE = "Successful";
	public static final String SUCCESS_DONATE_STATUS_MESSAGE = "Added Course Successfully ";
	public static final String NO_COURSE_FOUND = "no match available";

}