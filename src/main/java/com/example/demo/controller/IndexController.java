package com.example.demo.controller;

import com.example.demo.pojo.CreditAccount;
import com.example.demo.pojo.CreditAccount2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping
@Controller
public class IndexController {
	@RequestMapping("/helloHtml")
	public String testHelloHtml(Model model){

		// 创建账户1对象
		CreditAccount account1 = new CreditAccount();
//		account1.setAccountNo("48454");
		account1.setManagementOrg("村镇银行“WX”");
		account1.setAccountTag("64786425124312");
		account1.setOpenDate(LocalDate.of(2018, 11, 16));
		account1.setExpireDate(LocalDate.of(2036, 12, 16)); // 对应模板中的 "-"
		account1.setLoanAmount(new BigDecimal("500000"));
		account1.setCurrency("人民币元");
		account1.setCreditAgreementNo("签名");
		account1.setAccountStatus("正常");
		account1.setLastRecordDate(LocalDate.of(2028, 1, 16));
// 创建account2对象并赋值
		CreditAccount2 account2 = new CreditAccount2();
		account2.setBusinessType("其他3个人22消费贷款");   // 业务种类
		account2.setGuaranteeType("抵33押");              // 担保方式
		account2.setRepaymentTerms(1244);                 // 还款期数
		account2.setRepaymentFreq("月44");                // 还款频率
		account2.setRepaymentMethod("44-");               // 还款方式
		account2.setJointBorrowFlag("无44");              // 共同借款标志

		Map<String, String> userMap = new HashMap<>();
		userMap.put("name", "张三");
		userMap.put("age", "25");
		userMap.put("city", "北京");

// 传递到Thymeleaf模板（Spring Boot示例）
// model.addAttribute("account2", account2);
		List<Integer> list = new ArrayList<>();
		list.add(123465);
		list.add(266);
		list.add(355);
		list.add(4342);
		list.add(5342);
		list.add(656566);
		list.add(73233);
		list.add(855254);
		list.add(922323);
		list.add(102323);
		list.add(11234);
		List<Integer> list2 = new ArrayList<>();
		list2.add(12);
		list2.add(26);
		list2.add(35);
		list2.add(4342);
		list2.add(534);
		list2.add(6565);
		list2.add(732);
		list2.add(8552);
		list2.add(9223);
		list2.add(1023);
		list2.add(134);
// 将对象放入Model，传递给Thymeleaf\
		model.addAttribute("name", "张三");
		model.addAttribute("num", "6");
		model.addAttribute("list", list);
		model.addAttribute("account1", account1);
		model.addAttribute("account2", account2);
		model.addAttribute("list2", list2);
		model.addAttribute("userMap", userMap);


		return "index";
	}
}
