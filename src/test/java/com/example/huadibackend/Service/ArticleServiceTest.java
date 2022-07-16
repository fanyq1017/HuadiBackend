package com.example.huadibackend.Service;

import com.example.huadibackend.entity.Activity;
import com.example.huadibackend.entity.Article;
import com.example.huadibackend.service.ArticleService;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void addArticle() {
        Article article = new Article();

            article = new Article(-1, "江苏徐州：关于进一步加强疫情防控志愿服务工作的通知", 1, null, null, "shixun", "<p>民网北京5月27日电 （池梦蕊）一路小跑把刚买的外卖给独自在家的一双儿女放下，尹冬转身骑上电动车又回到了志愿服务的岗位上。自从5月18日“红色领航 同心抗疫”行动开展以来，门头沟区已有近千名社会志愿者和86家社会单位主动投身疫情防控第一线，他们积极参与卡口值守、测温验码、物资捐赠等各类服务，守卫自己的家园，贡献自己的力量。</p> <p>尹冬是门头沟区峰火社会工作服务中心的一名成员，这次是以社会力量组织团体参与志愿服务的。“看到发布的志愿服务微信小程序后，我第一时间报了名，这个招募平台让我们的志愿服务更加有的放矢了。”尹冬号召团队的11名成员报了名，已经参加疫情防控志愿服务40余人次。</p> <p><img src=\"https://chinavolunteer.mca.gov.cn/NVSI/LEAP/Download/default/2022/5/27/eb6b953b6c144ba5bf7d91b89ac9cec4.jpg\" alt=\"积极参与卡口值守。 人民网 池梦蕊摄\" /><br /> 当前，疫情防控正处于最紧要关头，门头沟区上下一心、同心抗疫，区委组织部启动了“红色领航 同心抗疫”行动，并推出“红色领航 同心抗疫”志愿服务对接平台，让镇街根据村居的需求发布志愿服务项目，明确志愿服务开展时间、地点、人员力量、服务内容等信息，各种社会力量可根据镇街发布的内容在平台对接需求，参与志愿服务，“供”“需”双方精准对接，开展“菜单式”服务和“量身式”上岗。</p> <p>“这个平台为属地政府和热心市民搭建了很好的桥梁，志愿者的加入，极大的缓解了社区抗疫一线人手不足的问题。”门头沟区永定镇党委委员、宣传委员杜宝仲表示，“对于参与服务的志愿者，我们都是先培训后上岗，让志愿者掌握基本防疫知识和必备防疫技能，再投入到日常的防疫工作中。”</p> <p>除了各类志愿服务组织参与服务，志愿者个人也可根据个人特长通过平台进行报名，由区委组织部统筹，将报名参与的志愿者个人信息分发到镇街，统筹开展志愿服务。</p> <p>赵文青是北京八中永定实验学校的一名老师，这次是以一名退伍老兵的名义参与志愿服务的。“我自己报名后，还发动了许多老战友报名，参与卡口值守、协助核酸检测等工作。”赵文青说，每周除了给学生上网课，其他时间都用来参与志愿服务，为疫情防控贡献自己的一份力量！</p> <p>志愿者们主动参与到秩序维护、测温验码、生活必需品采购配送、防疫物资发放等各类支援一线的防控服务、便民服务、宣传服务和专业服务中来，驻区非公企业也为志愿者们提供了1000份总保额1.5亿元的专项保险，让志愿者安心抗疫，汇聚起了门头沟区抗击疫情的强大合力。</p> <p>门头沟区委组织部副部长聂爽表示，本次疫情以来，门头沟区上下一心、争分夺秒、以快制快，发动党员干部、社会力量、志愿者同心抗疫。接下来，门头沟区将持续动员、深入发动全区各级、各领域社会力量，共同筑牢疫情防控防线，打好疫情防控阻击战。</p> <p>(责编：鲍聪颖、高星)</p>", 1, -1);
            articleService.addNewArticle(article);

    }

    @Test
    public void getArticleById()
    {
        Article article1 = articleService.getArticleById(2);
        System.out.println(article1);
    }

    @Test
    public void deleteArticleById()
    {
        Integer[] aid =new Integer[]{1,2,3,4};
        System.out.println(Arrays.toString(aid));
        System.out.println(articleService.deleteArticleById(aid));
    }

    @Test
    public void updateArticleState()
    {
        System.out.println(articleService.updateArticleState(11,2));
    }


}

