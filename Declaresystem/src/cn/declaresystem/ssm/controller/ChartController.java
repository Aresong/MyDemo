package cn.declaresystem.ssm.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.pojo.OrganizeChart;
import cn.declaresystem.ssm.service.ChartService;

@Controller
@RequestMapping("/chartCtrl/")
public class ChartController {
    @Resource
    ChartService chartService;

    @RequestMapping(value = "addChart")
    public String addChart(
            HttpSession session, @RequestParam MultipartFile chart, HttpServletRequest request, Model model) {
        //springmvc�ļ��ϴ�
        if (!chart.isEmpty()) {
            //��ȡԭ�ļ���
            String oldFileName = chart.getOriginalFilename();
            //��ȡ�ļ���׺
            String prefix = FilenameUtils.getExtension(oldFileName);
            if (prefix.equalsIgnoreCase("gif") ||
                    prefix.equalsIgnoreCase("bmp") ||
                    prefix.equalsIgnoreCase("jpg") ||
                    prefix.equalsIgnoreCase("jpeg") ||
                    prefix.equalsIgnoreCase("png")) {
                //ͨ��ImageIO��ȡͼƬ�����жϴ�С
                try {
                    BufferedImage image = ImageIO.read(chart.getInputStream());
                    int h = image.getHeight();
                    int w = image.getWidth();
                    if (h > 700 || w > 600) {
                        request.setAttribute("chartErr", "���ϴ����ļ���С�����Ϲ涨���������ϴ�");
                        return "chart";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("chartErr", "���ϴ����ļ���ʽ�����Ϲ涨���������ϴ�");
                return "chart";
            }
            Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
            //�������ļ�����ֹ��ͬ�û��ϴ��ļ�����
            String file_Name = System.currentTimeMillis() + "." + prefix;
            OrganizeChart _chart = new OrganizeChart();
            _chart.setGr_id(gr_id);
            _chart.setFile_name(file_Name);
            chartService.saveChartInfo(_chart);
            model.addAttribute("chart", file_Name);
            //��ȡϵͳ�ĵ�ǰ·��
            String destPath = request.getSession().getServletContext().getRealPath("upload/");
            File destFile = new File(destPath + File.separatorChar + file_Name);
            //��Դ�ļ�������Ŀ���ļ��������ļ������п���
            try {
                FileUtils.copyInputStreamToFile(chart.getInputStream(), destFile);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return "redirect:/chartCtrl/getChart";
        } else {
            request.setAttribute("chartErr", "���ϴ����ļ�Ϊ�գ��������ϴ�");
            return "chart";
        }
    }

    @RequestMapping(value = "getChart")
//	@ResponseBody
//	public String getChart(HttpSession session){
//		Integer gr_id = ((Enterprise)session.getAttribute("enterpriseObject")).getId();
//		String result = "${pageContext.request.contextPath}/upload/"+chartService.getChartName(gr_id);
//		return JSONArray.toJSONString(result);
//	}

    public String getChart(HttpSession session, Model model) {
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        String chartName = chartService.getChartName(gr_id);
        model.addAttribute("chartName", chartName);
        return "chart";
    }
}
