package message.dao.impl;

import java.util.List;

import message.dao.AdmissionInformationDao;
import message.domain.AdmissionInformation;

public class AdmissionInformationDaoImpl extends BaseDao<AdmissionInformation> implements AdmissionInformationDao{

	@Override
	public AdmissionInformation getAdmisInf(String major,String location) {
		String sql = "";
		AdmissionInformation admissionInformation = get(sql,major,location);
		return admissionInformation;
	}

	//获取多条记录
	@Override
	public List<AdmissionInformation> getAdmisInfForList(String major,String type,String location) {
		String sql = "select * from message where major = ? and type = ? and location = ?";
		List<AdmissionInformation> admissionInformationForList = getForList(sql,major,type,location);
		return admissionInformationForList;
	}

	@Override
	public List<AdmissionInformation> getHotAdmisInfForList(String location) {
		String sql = "";
		List<AdmissionInformation> hotAdmissionInformationForList = getForList(sql,location);
		return hotAdmissionInformationForList;
	}

	@Override
	public List<AdmissionInformation> getColdAdmisInfForList(String location) {
		String sql = "SELECT * from message";
		List<AdmissionInformation> coldAdmissionInformationForList = getForList(sql);
		return coldAdmissionInformationForList;
	}

	@Override
	public List<AdmissionInformation> getAdmisInfForList(String major, String location) {
		// TODO Auto-generated method stub
		return null;
	}

}
