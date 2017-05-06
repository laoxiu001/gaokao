package message.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import message.dao.AdmissionInformationDao;
import message.dao.impl.AdmissionInformationDaoImpl;
import message.domain.AdmissionInformation;

public class TestJDBCTools {

	@Test
	public void test(){
		AdmissionInformationDao aidi = new AdmissionInformationDaoImpl();
        List<AdmissionInformation> list = new ArrayList<>();
        list = aidi.getAdmisInfForList("电气工程及其自动化","重庆");
        if(list!=null){
        	for(int i = 0;i<list.size();i++){
        		System.out.println(list.get(i));
        	}
        }
	}
}
