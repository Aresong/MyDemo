package cn.bdqn.house.action;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import util.PageSupport;

import cn.bdqn.house.entity.District;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HousePicture;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.entity.HouseUser;
import cn.bdqn.house.entity.Street;
import cn.bdqn.house.service.IDistrictService;
import cn.bdqn.house.service.IHousePictureService;
import cn.bdqn.house.service.IHouseService;
import cn.bdqn.house.service.IHouseTypeService;
import cn.bdqn.house.service.IStreetService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����9:12:18
 *version: 1.0
 *description:
 */
public class HouseAction extends ActionSupport {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private House house;
    private IHouseService houseService;
    private List<House> houseList;

    private HouseType houseType;
    private List<HouseType> houseTypelist;
    private IHouseTypeService houseTypeService;

    private List<District> districtlist;
    private District district;
    private IDistrictService districtService;

    private HousePicture housePicture;
    private IHousePictureService housePictureService;

    private File file;
    private String fileContentType;
    private String fileFileName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public IHousePictureService getHousePictureService() {
        return housePictureService;
    }

    public void setHousePictureService(IHousePictureService housePictureService) {
        this.housePictureService = housePictureService;
    }

    public HousePicture getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(HousePicture housePicture) {
        this.housePicture = housePicture;
    }

    private Map<Integer, Set<Street>> streetMap = new HashMap<Integer, Set<Street>>();
    private Street street;
    private IStreetService streetService;

    private PageSupport pageSupport = new PageSupport();

    public PageSupport getPageSupport() {
        return pageSupport;
    }

    public void setPageSupport(PageSupport pageSupport) {
        this.pageSupport = pageSupport;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public IHouseService getHouseService() {
        return houseService;
    }

    public void setHouseService(IHouseService houseService) {
        this.houseService = houseService;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }


    public List<District> getDistrictlist() {
        return districtlist;
    }

    public void setDistrictlist(List<District> districtlist) {
        this.districtlist = districtlist;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public IDistrictService getDistrictService() {
        return districtService;
    }

    public void setDistrictService(IDistrictService districtService) {
        this.districtService = districtService;
    }

    public Map<Integer, Set<Street>> getStreetMap() {
        return streetMap;
    }

    public void setStreetMap(Map<Integer, Set<Street>> streetMap) {
        this.streetMap = streetMap;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public IStreetService getStreetService() {
        return streetService;
    }

    public void setStreetService(IStreetService streetService) {
        this.streetService = streetService;
    }


    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public List<HouseType> getHouseTypelist() {
        return houseTypelist;
    }

    public void setHouseTypelist(List<HouseType> houseTypelist) {
        this.houseTypelist = houseTypelist;
    }

    public IHouseTypeService getHouseTypeService() {
        return houseTypeService;
    }

    public void setHouseTypeService(IHouseTypeService houseTypeService) {
        this.houseTypeService = houseTypeService;
    }


    public String houseTypeShow() throws Exception {
        System.out.println("**********************��ת�������ҳ��*************************");
        houseTypelist = houseTypeService.getHouseTypes();
        districtlist = districtService.getDistrictList();
        for (District district : districtlist) {
            streetMap.put(district.getId(), district.getStreets());
        }
        return SUCCESS;
    }

    //��ʾ������Ϣ
    public String show1() throws Exception {

        return SUCCESS;
    }

    //��ʾ������Ϣs
    public String show() throws Exception {
        System.out.println("*****************ʹ��show����*****************");
        int totalcount = houseService.getTotalCount();
        pageSupport.setTotalcount(totalcount);
        if (pageSupport.getPagestart() > pageSupport.getTotalpage()) {
            pageSupport.setPagestart(pageSupport.getTotalpage());
        }
        if (pageSupport.getPagestart() <= 0) {
            pageSupport.setPagestart(1);
        }
        ActionContext ac = ActionContext.getContext();
        ac.getSession().put("pageSupport", pageSupport);
        ac.getSession().put("house", house);
        houseList = houseService.getHouseList(house, pageSupport.getPagestart(), pageSupport.getPagesize());
        ac.getSession().put("houseList", houseList);

        return SUCCESS;
    }


    //�޸ķ�����Ϣ��ʾ
    public String update() {
        System.out.println("*************************�޸ķ�����Ϣ��ʾ��*********************************************");
        houseTypelist = houseTypeService.getHouseTypes();
        districtlist = districtService.getDistrictList();
        for (District district : districtlist) {
            streetMap.put(district.getId(), district.getStreets());
        }
        house = houseService.getByHouseId(house.getId());
        ActionContext ac = ActionContext.getContext();
        ac.getSession().put("house", house);
        ac.getSession().put("hps", house.getHousePictures());
        return SUCCESS;
    }

    //�޸ķ�����Ϣִ��
    public String updatedata() {
        System.out.println("������������������������������������������������������������������������������ִ���޸ġ�����������������������������������������������������������������������������������������������");
        String result = "";
        try {
            HousePicture housePicture = new HousePicture();
            ActionContext ac = ActionContext.getContext();
            ac.getSession().put("house", house);
            HouseUser houseUser = (HouseUser) ac.getSession().get("_user");
            house.setHouseUser(houseUser);
            Set<HousePicture> hps = (Set<HousePicture>) (ac.getSession().get("hps"));
            for (HousePicture h : hps) {
                housePicture.setId(h.getId());
            }
            if (file != null) {
                String pathname = ServletActionContext.getServletContext().getRealPath("upload") + File.separatorChar + fileFileName;
                File destFile = new File(pathname);
                FileUtils.copyFile(file, destFile);
                housePicture.setHouse(house);
                housePicture.setTitle(fileFileName);
                housePicture.setUrl("upload/" + fileFileName);
                housePictureService.updateHousePicture(housePicture);
            }

            houseService.updateHouse(house);
            result = SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            result = INPUT;
        }
        return result;
    }


    //ִ�����Ӳ���
    public String add() throws Exception {
        System.out.println("*****************ִ������**********************");
        HousePicture housePicture = new HousePicture();

        house.setAdddate(new Date());
        ActionContext ac = ActionContext.getContext();
        ac.getSession().put("house", house);
        HouseUser houseUser = (HouseUser) ac.getSession().get("_user");
        house.setHouseUser(houseUser);
        String result = "";
        try {
            String pathname = ServletActionContext.getServletContext().getRealPath("upload") + File.separatorChar + fileFileName;
            if (houseService.saveHouse(house)) {
                File destFile = new File(pathname);
                FileUtils.copyFile(file, destFile);
                housePicture.setTitle(fileFileName);
                housePicture.setHouse(house);
                housePicture.setUrl("upload/" + fileFileName);
                housePictureService.saveHousePicture(housePicture);

                result = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = INPUT;
        }
        return result;
    }


    //ִ��ɾ������
    public String deletedata() throws Exception {
        System.out.println("*****************ִ��ɾ��**********************");
        HousePicture housePicture = new HousePicture();
        house = houseService.getByHouseId(house.getId());
        housePicture.setHouse(house);
        for (HousePicture h : house.getHousePictures()) {
            housePicture.setId(h.getId());
            housePicture.setTitle(h.getTitle());
            housePicture.setUrl(h.getUrl());
        }
        housePictureService.deleteHousePicture(housePicture);
        houseService.deleteHouse(house);
        return SUCCESS;
    }

    //�鿴������ϸ��Ϣ
    public String lookhouse() {
        House house1 = houseService.getByHouseId(house.getId());
        ActionContext ac = ActionContext.getContext();
        ac.getSession().put("house", house1);

        return SUCCESS;
    }


}
