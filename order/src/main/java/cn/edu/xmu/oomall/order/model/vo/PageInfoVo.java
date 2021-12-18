package cn.edu.xmu.oomall.order.model.vo;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @author 潘越
 * @date 2021/12/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分页视图")
public class PageInfoVo <T>{
    List<T> list;
    Long total;
    Integer page;
    Integer pageSize;
    Integer pages;

    public PageInfoVo(PageInfo<T> pageInfo) {
        list = pageInfo.getList();
        total = pageInfo.getTotal();
        page = pageInfo.getPageNum();
        pageSize = pageInfo.getPageSize();
        pages = pageInfo.getPages();
    }
}
