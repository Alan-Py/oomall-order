//package cn.edu.xmu.oomall.order.microservice;
//
//import cn.edu.xmu.privilegegateway.annotation.aop.LoginName;
//import cn.edu.xmu.privilegegateway.annotation.aop.LoginUser;
//import cn.edu.xmu.privilegegateway.annotation.util.ReturnObject;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.time.LocalDateTime;
//
//@FeignClient(name = "Payment")
//public interface PaymentService {
//    /**
//     * 用于Api 14
//     * 通过订单号查询退款单信息
//     * @param loginUser
//     * @param loginUsername
//     * @param shopId
//     * @param documentId
//     * @param state
//     * @param beginTime
//     * @param endTime
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    @ApiOperation(value = "通过id查退款单")
//    @GetMapping("/shops/{shopId}/refund")
//    ReturnObject getRefundByExample(@LoginUser Long loginUser,
//                                    @PathVariable("shopId")Long shopId,
//                                    @RequestParam(value = "documentId",required = false) String documentId,
//                                    @RequestParam(value = "state",required = false) Byte state,
//                                    @RequestParam(value = "beginTime",required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") LocalDateTime beginTime,
//                                    @RequestParam(value = "endTime",required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") LocalDateTime endTime,
//                                    @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
//                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize);
//}
