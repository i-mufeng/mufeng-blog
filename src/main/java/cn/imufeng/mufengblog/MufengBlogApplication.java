package cn.imufeng.mufengblog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MuFeng
 * @since 2023-5-14 01:19:26
 */
@Slf4j
@SpringBootApplication
@RestController
public class MufengBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MufengBlogApplication.class, args);
		log.info("꒰ᐢ⸝⸝•༝•⸝⸝ᐢ꒱ --> 启动成功 <-- ꒰ঌ( ⌯' '⌯)໒꒱");
	}

	@GetMapping("/")
	public String index() {
		return """
				欢迎访问沐风的个人博客后台。
				前端请直接访问：<a href="https://imufeng.cn">https://imufeng.cn</a>
				""";
	}
}
