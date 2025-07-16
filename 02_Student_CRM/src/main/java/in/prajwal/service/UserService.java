package in.prajwal.service;

import java.util.List;


import in.prajwal.binding.LoginForm;
import in.prajwal.binding.SignUpForm;
import in.prajwal.binding.UnlockForm;
import in.prajwal.entity.StudentEnqEntity;

public interface UserService {
	
	
	
	public boolean signUp(SignUpForm form);
	
	public boolean unlockAccount(UnlockForm form);
	
	public String login(LoginForm form);
	
	public boolean forgotPwd(String email);

//	List<StudentEnqEntity> getEnquries();
}

