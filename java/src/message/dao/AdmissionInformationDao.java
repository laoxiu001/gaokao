package message.dao;

import java.util.List;

import message.domain.AdmissionInformation;

public interface AdmissionInformationDao {
	/**
	 * 获取指定的录取信息
	 * @param location
	 * @param major
	 * @return
	 */
	public AdmissionInformation getAdmisInf(String major,String location);
	
	/**
	 * 获取多条录取信息
	 * @param location
	 * @return
	 */
	public List<AdmissionInformation> getAdmisInfForList(String major,String location);
	
	/**
	 * 获取多条录取信息
	 * @param location
	 * @return
	 */
	public List<AdmissionInformation> getAdmisInfForList(String major,String type,String location);
	/**
	 * 获取热门的录取信息
	 * @param location
	 * @return
	 */
	public List<AdmissionInformation> getHotAdmisInfForList(String location);
	
	/**
	 * 获取冷门的录取信息
	 * @param location
	 * @return
	 */
	public List<AdmissionInformation> getColdAdmisInfForList(String location);
	
}
