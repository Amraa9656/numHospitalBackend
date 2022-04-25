package num.edu.mn.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import num.edu.mn.domain.User;
import num.edu.mn.repo.UserRepository;
import num.edu.mn.usermodel.Usermodel.Model.ResGenaral;
import num.edu.mn.usermodel.Usermodel.Model.ResUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResGenaral> saveUser(User user)
    {
        ResGenaral resSend = new ResGenaral();
       try {
           userRepository.save(user);
           resSend.setCode(200);
           resSend.setStatus("Success");
           resSend.setMessage("Амжилтай");
       }catch (Exception e )
       {
           resSend.setCode(300);
           resSend.setStatus("Fail");
           resSend.setMessage(e.getMessage());
       }
        return ResponseEntity.ok().body(resSend);
    }

    @Override
    public ResponseEntity<ResGenaral> getuser(String requestry)
    {
        ResUser res = new ResUser();
        ResGenaral resSend = new ResGenaral();
        try {
            User user = userRepository.findByRequestry(requestry);
            res.setUserId(user.getUserid());
            res.setFirstName(user.getFirstname());
            res.setLastName(user.getLastname());
            res.setRequestry(user.getRequestry());
            res.setAllergies(user.getAllergies());
            res.setAddress(user.getAddress());
            res.setEducation(user.getEducation());
            res.setProfession(user.getProfession());
            res.setJobAddress(user.getJobaddress());

            resSend.setCode(200);
            resSend.setStatus("Success");
            resSend.setMessage("Амжилтай");
            resSend.setData(res);
        }catch (Exception e)
        {
            resSend.setCode(300);
            resSend.setStatus("Fail");
            resSend.setMessage(e.getMessage());
        }
        return ResponseEntity.ok().body(resSend);
    }

    @Override
    public ResponseEntity<ResGenaral> getusers()
    {
        ResGenaral resSend = new ResGenaral();
       try {
           List<ResUser> data= new ArrayList<>();
           List<User> users = userRepository.findAll();
           for (User i : users)
           {
               ResUser wt = new ResUser();
               wt.setUserId(i.getUserid());
               wt.setFirstName(i.getFirstname());
               wt.setLastName(i.getLastname());
               wt.setAddress(i.getAddress());
               wt.setRequestry(i.getRequestry());
               wt.setAllergies(i.getAllergies());
               wt.setAddress(i.getAddress());
               wt.setEducation(i.getEducation());
               wt.setProfession(i.getProfession());
               wt.setJobAddress(i.getAddress());
               data.add(wt);
           }
           resSend.setCode(200);
           resSend.setStatus("Success");
           resSend.setMessage("Амжилтай");
           resSend.setData(data);
       }catch (Exception e)
       {
           resSend.setCode(300);
           resSend.setStatus("Fail");
           resSend.setMessage(e.getMessage());
       }
        return ResponseEntity.ok().body(resSend);
    }
}
