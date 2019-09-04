package util;

/*
 *@author:Dongming Tian
 *@date:2017-6-13 ����11:18:00
 *version: 1.0
 *description:
 */
public class PageSupport {
    private int pagestart = 1;//��ǰҳ
    private int pagesize = 4;//ÿҳ��ʾ��
    private int totalcount;//�ܼ�¼��
    private int totalpage;//��ҳ��

    public int getPagestart() {
        return pagestart;
    }

    public void setPagestart(int pagestart) {
        this.pagestart = pagestart;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public int getTotalpage() {
        if (totalcount % pagesize == 0) {
            return totalcount / pagesize;
        } else {
            return totalcount / pagesize + 1;
        }

    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

}
