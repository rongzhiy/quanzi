# 基于SpringBoot的校园问答社区系统设计与实现（前后端分离）

![ppt](https://mp.weixin.qq.com/s?__biz=MzIwMjc2MTk0Ng==&mid=2247484702&idx=1&sn=ba5c32bd58515e69374b32eb8b2cdeee&chksm=96d8f6aba1af7fbd8f96dc109402ea09bd6a1a643424003b52aa351618b8ac3d20f3bf882c7f&scene=178&cur_album_id=1975063588545331201#rd)

目  录
[摘  要	III](#_Toc14978)
[ABSTRACT	IV](#_Toc32666)
[1.绪论	1](#_Toc30822)
[1.1 研究背景	1](#_Toc18870)
[1.2 国内外研究现状	1](#_Toc9949)
[1.2.1国外研究现状	1](#_Toc20374)
[1.2.2 国内研究现状	2](#_Toc14994)
[1.3 项目的意义	2](#_Toc6423)
[1.4 论文结构	3](#_Toc29255)
[2.相关技术介绍	5](#_Toc20203)
[2.1 SpringBoot与SSM	5](#_Toc27924)
[2.2 Vue与前端UI组件	5](#_Toc28744)
[2.3 REST与前后端分离	6](#_Toc8145)
[2.4 Spring Security与JWT	7](#_Toc12090)
[3.需求分析	9](#_Toc2721)
[3.1 任务概述	9](#_Toc28795)
[3.2 系统功能需求	10](#_Toc22512)
[3.3 非功能需求	10](#_Toc4851)
[3.3.1 环境需求	10](#_Toc6257)
[3.3.2 系统特征	11](#_Toc1106)
[4.系统总体设计	12](#_Toc11217)
[4.1 系统架构设计	12](#_Toc4961)
[4.2 系统软件结构设计	13](#_Toc9275)
[4.2.1 微信小程序客户端软件结构设计	13](#_Toc13823)
[4.2.2 Web后台软件结构设计	14](#_Toc8940)
[4.3 数据库设计	16](#_Toc26599)
[4.3.1 系统用户及用例图	16](#_Toc24160)
[4.3.2 实体描述及E-R图	17](#_Toc12458)
[4.3.3 数据库结构	19](#_Toc18140)
[5.系统设计及实现	27](#_Toc4745)
[5.1 开发环境与工具	27](#_Toc9319)
[5.1.1 开发环境	27](#_Toc28946)
[5.1.2 开发工具	27](#_Toc8558)
[5.2 后端接口设计实现	27](#_Toc13741)
[5.3 微信小程序端的设计实现	28](#_Toc4009)
[5.3.1 登录授权功能实现	28](#_Toc27000)
[5.3.2 问答功能实现	30](#_Toc24824)
[5.3.3 问答内容分类展示功能	32](#_Toc30499)
[5.3.4 消息公告功能实现	33](#_Toc23629)
[5.3.5 个人信息管理功能	34](#_Toc7353)
[5.4 Web后台（CMS）内容管理系统	34](#_Toc5868)
[5.4.1 系统权限管理功能实现	35](#_Toc5220)
[5.4.2 微信用户管理功能实现	36](#_Toc15479)
[5.4.3 校园问答社区管理功能实现	37](#_Toc29882)
[5.4.4 系统管理功能实现	38](#_Toc17580)
[总结	39](#_Toc3095)
[参考文献	40](#_Toc27581)
[致  谢	41](#_Toc22536)


摘  要
随着互联网技术的迅猛发展，人们进入了“信息大爆炸”的大数据时代。在这个数据量巨大但价值密度低的时代，仅依靠搜索引擎去寻求答案变得越来越艰难。问答社区是这一历史背景下的优秀产物，然而以知乎为例，问答社区内容存在着与在校大学生在校学习生活不紧密不具体等问题。采用SpringBoot框架开发的校园问答社区系统便应运而生。
本文首先阐述了系统开发背景，国内外研究现状与项目意义；介绍了所使用的技术；进而分析了系统的需求和用例分析；然后设计了前后端分离的系统，后端用Java语言编写接口，前端分为WEB后台内容管理端和微信小程序端，并对各个部分进行详细说明；最后按照系统设计编码实现系统的功能，进行结果展示。
总的来说，基于SpringBoot的校园问答社区系统在基本功能方面得以实现，利用现代化美观UI组件和先进安全技术，不仅提高了用户体验，而且在安全和性能方面也得到了提升。采用前后端分离开发模式，降低了代码结构之间的耦合，使系统易于开发与维护；基于Vue框架开发微信小程序和WEB端内容管理系统（CMS管理系统）适应不同用户的使用。 

关键词：校园问答社区；SpringBoot框架；Vue框架；微信小程序

ABSTRACT
As the Internet technology has leaped forward, there comes an era of information explosion where huge data have low value density. Therefore, relying on search engines is of great difficulty to find a right answer. In this case, question and answer (Q&A) community closes the loophole of the search engine. However, taking the application Zhihu as an example, contents of Q&A community are low relative to college students' study and life, which triggers the emergence of Q&A community in campus system with SpringBoot framework. 
This thesis first briefly introduces the study background, literature review, significance of the thesis and technologies involved in the project. In addition, this thesis outlines the system requirements and analyzing cases. Plus, the author designs a project to seperate front and back end, in which the back end is proceeded with Java language to write the interface, and the front end is divided into Web background management and WeChat mini program. Each part of the project is attached with a detailed description. Finally, this thesis displays the function of the system realized through the system design and coding. 
In general, the campus Q&A community system integrated with SpringBoot has realized its basic functions. With the application of modern UI components and advanced security technology, users have an easy access to operation experiences and security. The mode of separated front and back end reduces the coupling matters among coding structures, which makes the system easy to maintain. Furthermore, WeChat mini program and Web management system (CMS management system) are developed based on VUE framework to adapt to different users.

Key Words: Campus Q&A Community、SpringBoot framework、Vue framework、WeChat applet

# 1.绪论
## 0.1 研究背景
随着经济社会的迅猛发展，人们从信息时代进入了大数据时代。大数据时代下的数据拥有巨大的数据、丰富多彩的数据类型、超快的数据流动速度，但同时也具有价值密度低的特点[1]。汹涌而来的信息常使人无所适从，如何快速、准确地获取所需信息，成为了目前人们工作、生活等方面的一大需求[2]。此时搜索引擎很好的解决了这个问题，人们可以通过互联网分享、检索知识信息。然而我们逐渐发现，在“信息大爆炸”的当下，搜索引擎使更多内容变得平民化且常被商业公司垄断，人们很难高效获得专业知识。
人们通过建立以Wiki技术为核心的网络百科全书和在线问答社区提问与回答的方式去传承和共享知识[3]。目前随着互联网用户规模不断扩大、专业化与社会化趋势不断加强，保持“精英化”氛围的在线知识问答社区在近些年逐渐兴起，社区内分享的高质量内容越来越多，问答社区逐渐成为人们寻求答案的重要途径[4]。区别于百科式的名词解释，知识问答社区拥有互动性和延展性，知识得到更好地交流、分享和检索，弥补了搜索引擎的一些弊病。
## 0.2 国内外研究现状
### 1.2.1 国外研究现状
国外最热门的问答社区是Quora。Quora是Charlie Cheever和Adam D' Angelo在2009年创办。Quora其宗旨是在人类集体智慧产生的高质量经验中找到问题的答案，对答案进行排序，摆脱结构化、机器算法单一的搜索引擎到时的答案内容浅显通俗的问题；吸收社交网络和维基百科的特点，成为了大众化的问答社区[5]。
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370835600-08df5940-7d61-493e-93f6-e7eb5f73d676.png#averageHue=%23bec6b8&id=W4xFc&originHeight=318&originWidth=689&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图1 Quora官网图
### 1.2.2 国内研究现状
随着全球移动互联网的迅猛发展，用户的规模在持续扩大，专业化与社会化趋势不断加强，国内问答社区大致分为两类：一类是依托搜索引擎的百度知道、360问答、Yahoo Answers等；一类是结合社交服务的Quora和知乎的新一代问答社区[6]。
目前国内最大的社会性问答社区是知乎[7]。知乎于2011年1月正式上线，以让人们更好地分享知识、经验和见解，找到自己的解答为品牌使命。知乎的成功之处就在与不仅仅构建用户与问题之间提问、回答、搜素关系，还加入了社交元素：可以邀请领域专家来回答，后来者看到回答内容，可以点赞、评论、收藏，甚至还可以与回答者进行关注交流[4]。

## 0.3 项目的意义


国内最大的问答社区——知乎逐渐成为国内问答社区的主流，是人们获取问答答案的重要来源。然而知乎也存在这样的问题：涉及知识领域广，覆盖地理空间大，导致知乎上对各区域大部分人的共性问题得到很好的解决，而对于一些区域性小众化问题的求解是存在障碍的。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370835880-2d3d702e-2db5-4c33-b76c-d8aaf451f77f.png#averageHue=%23f9f8f8&id=Yra2I&originHeight=628&originWidth=971&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图2 知乎分类截图

在校园内搭建一个校园问答社区平台便是为了弥补当前问答社区的缺漏和弊病。校园问答社区是问答社区的场景具体化，生活在同一物理空间下的人们拥有着其他地方没有的个性化问题。在校大学生可以使用本系统——校园问答社区，对周围的人进行提问获取更符合自身需要的回答。
在校大学生常常会遇到一些学习和生活中的问题。例如，在学习生活方面的专业选择、学习方法、就业准备等问题，高年级的学习经验与知识总结非常值得低年级的同学借鉴，但是缺乏广泛经验交流以及准确信息共享的桥梁与平台。在就业方面，民生之本离不开就业，当前，大学生“就业难”成为了解决就业问题的一大难题[8]。提供校园问答社区，能使低年级的同学可以得到学长学姐的帮助，提前了解专业就业方向方面知识，尽早做好就业准备。这样可以大大提高大学生就业率。目前，虽然社交软件取得了跨越式的发展，同学或师生间的沟通交流也大都通过一些聊天软件实现，但聊天软件存在问答内容管理混乱、记录保存不完善、获取信息范围限制、信息准确度欠佳以及难以共享等问题。
为了让在校大学生能够在学习和生活中有效获得解答，并在繁杂且巨大的数据中找到更优质的答案，基于SpringBoot的校园问答社区系统便应运而生。通过用户对某一问题的解答参与互动，推选出较为优质的答案，有利于甄别信息；同时通过标签机制，能让更多的同学能在较短时间内获得某一领域的系统化知识。另外，校园问答社区系统很容易找到跟自己志趣相投的伙伴，激发大家信息共享的热情，增进同学之间的情谊与校园文化氛围。

## 0.4 论文结构
本文将用五个章节去介绍基于SpringBoot的校园问答社区的设计与实现，其内容梗概为：
第一章是绪论，从问答社区的研究背景和国内外研究现状分别做出诠释和分析，进而引出项目实施的意义所在。
第二章是相关技术的介绍，把开发系统所用的核心技术点和在项目中的使用做了简要概述。
第三章是需求分析，首先介绍系统的任务概述，然后从系统的功能需求、非功能需求以及系统用户与用例分析三方面详细说明系统的需求情况。
第四章是系统总体设计，根据第三章的系统需求分析分别从系统架构、系统软件结构和数据库三大模块进行系统的整体设计，给出相应图表进行了展示。
第五章是系统设计与实现，根据系统的整体需求与设计，从系统开发环境和工具、微信小程序端的设计实现、WEB后台管理系统设计实现再到后端接口设计四个方面进行了阐述与成果展示。


# 2.相关技术介绍
## 2.1 SpringBoot与SSM
SpringBoot是在2013年由Pivotal团队推出的开发框架，其目的便是为了简化开发Spring项目时候的配置，调试，部署工作[9]。其有两大核心特点：约定大于配置，开箱即用。在配置方式上，SpringBoot提供了免XML配置的开发体验，开发者免去了Spring开源框架的繁琐配置，用户不用编写XML文件，提供了各种启动器。只需在Maven的pom配置文件中添加少量的配置，即可获得需要的相关依赖，开发者专可以注于业务逻辑的开发[10]。
本系统使用SpringBoot整合SpringMVC和MyBatis。SpringMVC用户接收请求，MyBatis用于进行数据操作，快速开发应用。SpringMVC把WEB应用分为数据层、控制层和视图层，这种松耦合的方式能让代码程序逻辑更加清晰明了，方便程序的开发与后期维护[11]。MyBatis是一个出色的持久层框架，它封装了JDBC，弱化了对数据库的底层操作，把SQL从代码中抽离出来。开发人员能够在简单的配置之后，只需关注业务开发逻辑，编写相应的SQL便可实现对数据库的操作，降低SQL和代码之间的耦合，使得开发变得更加容易[12]。
本系统应用SpringBoot整合SpringMVC和MyBatis，根据配置方案，可以做到开箱即用[13]。

## 2.2 Vue与前端UI组件
Vue是构建强大客户端应用的技术体系中的核心库，是一款高性能的JavaScript框架。Vue框架能够把一个网页分为多个可复用组件，每个组件都有自己单独的HTML骨架，CSS样式和JavaScript脚本，具有很好的测试性和维护性[14]。除了核心的Vue框架，还有几个库和Vue配合起来非常好用。Vue-router用来路由控制，根据应用不同的URL来显示不同的内容；vuex用于状态管理，通过一个全局数据中心在组件间共享数据。
Vue非常适合用于前后端分离的模式下开发前端，因为其不仅可以自己管理前端的路由和数据信息，还采用了MVVM模型，只要后端提供的接口返回数据的名称与格式不变，后端进行大量更改都不会影响前端的开发[15]。MVVM模型如图3所示：
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370836131-6c491905-374d-4e50-8af2-84e00a2b6f27.png#averageHue=%23191212&id=QuZor&originHeight=194&originWidth=878&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图3 MVVM模型图

本项目使用了基于Vue的第三方UI库uView和ElementUI，分别开发了基于uniapp实现的微信小程序和后台内容管理系统。
本系统利用uniapp实现微信小程序端，运用了Vue.js的语法和微信小程序提供的API，既保持了Vue.js的优点，又极大降低了开发测试成本，也有利于后期适应其他平台的编译打包。微信小程序前端开发中，选用了uView，uView 是目前开发uni-app的最好UI框架选择，使用uView可以使项目得到优质的前端风格统一以及快速搭建前端组件，实现前端页面构建。
WEB后台管理系统采用了Element，Element是由饿了么公司前端团队开源的基于Vue的组件库。Element基于Vue却不依赖于Vue的前端开发UI框架，Elementui提供丰富统一、符合用户习惯的语言和概念的组件实现系统设计风格的统一；通过简洁直观的操作流程和反馈信息使用户能快速理解系统功能与反馈问题。它是目前网站后台开发的强大UI库[14]。
## 2.3 REST与前后端分离
REST（Representational Atate Transfer）是一种Web软件架构风格。在REST中，资源是由URI来指定的，对资源的增删改查操作可以通过HTTP协议提供的GET、POST、PUT、DELETE等方法实现。在前后端分离项目中，一个设计良好的WEB软件架构必然满足REST风格。
前后端分离开发方式也是目前互联网项目开发的标准。其核心思想是后端为前端提供RESTful风格的接口，前端根据URL发送请求调用，可以JSON数据格式进行前后端交互[15]。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370836331-bfccc171-82df-49bb-9ad8-cb81a2af425f.png#averageHue=%23363636&id=P7eic&originHeight=180&originWidth=566&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图4 RESTful架构处理请求的流程

本系统完全基于前后端分离的方式，利用Java语言为前端编写后端接口，前端采用基于Vue.js框架开发前端界面。前后端分离使得后端（应用）服务器的负载压力，前端可以单独部署与其他服务器，服务器不必需要解析前端页面，前端发送异步的http请求到后端接口进行交互，不仅用户体验得到了提升，而且软件开发分工明确、提高了开发效率。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370836572-f70f3e79-a060-4467-87fd-a5b072208822.png#averageHue=%230a0a0a&id=W5zEG&originHeight=332&originWidth=686&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图5 前后端分离示意图

## 2.4 Spring Security与JWT
Spring Security为Java应用开发提供了安全的机制，能实现身份验证和授权[16]。 Spring+Spring Security组合框架存在着配置复杂，高耦合，代码量多的问题导致项目实现困难，开发周期长，而利用SpringBoot整合Spring Security框架，大幅度降低了开发维护的成本，缩短了开发周期[17]。
JSON Web token（JWT）是被设计紧凑且安全的，在两个网络实体间安全传递声明JSON数据的开发的标准。其有三部分字符串相连，并用点号分割，可通过Header或是HTTP的参数进行传输。在本校园问答社区系统中，JWT用来传递用户的身份信息，以便根据用户登录状态进行给予不同权限[[1]](#footnote-1)。
我们知道http协议本身是一种无状态的协议，是无记忆的，这就导致用户每次请求时都需要重复进行用户认证，传统的基于session认证便是如此。Session一般存储在服务器所在主机的内存中，用户数量增多，服务端就得增加硬件性能来维持用户体验；在分布式应用上，基于内存存储的session认证或降低应用的扩展能力；session常会在cookie存储，cookie又容易被泄露，用户会很容易受到攻击。Jwt工作流程[18]：
用户注册登录应用时，携带账号与密码来请求后端服务器
服务器通过验证用户信息，给客户端发送token
客户端在cookie中保存token，在以后的请求中都携带token，此时token便是用户凭证了，一旦用户登录，后续每个请求都将包含JWT，允许用户访问该令牌允许的路由、服务和资源。
后端验证token是否通过，若通过则返回业务需要的数据
若不通过则说明token在一段时间内失效，客户端发送刷新token请求给后端，后端执行刷新操作，新的请求再次携带token。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370836882-80051acf-edf5-42f2-b0fd-b87845733299.png#averageHue=%23262626&id=WQ1s2&originHeight=484&originWidth=902&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图6 JWT执行流程图

本系统基于SpringBoot整合Spring Security做JWT认证与授权，这样的方式带来了的好处有：服务端不在保存用户状态，只做认真，服务端的内存压力大大被降低；在分布式应用汇总，我们可以通过负载均衡器将token传递到任何服务器，应为任何地方都没有状态或会话信息，有利于服务器扩展；token设置了过期时间，token过期用户需要重新登录授权，这样有助于我们保持安全。

# 3.需求分析
在软件开发项目中，需求时不断变化的，是不稳定的。所以应尽可能明确需求，有助于降低项目开发失败的风险，有利于为后续的系统设计、编码、测试与维护阶段打下良好的基础[19]。本章就校园问答社区系统在功能性需求、非功能性需求和设计约束方面进行详细的需求分析。

## 3.1 任务概述
本校园问答社区主要实现在校大学生以及老师之间的问答内容发布，问答分类展示，精选问答，点赞，评论，收藏，分享等基础功能，以及实现管理员对问答内容的管理，权限角色控制。
校园问答社区系统主要是用于校园里学生老师之间进行问答交流的一种平台，在校大学生通过利用该系统提交自己学习生活中的一些疑问，能够及时得到来自同一学校在校同学与已毕业师兄师姐之间的回答，从而解决自己的疑惑。本校园问答社区侧重与知识类经验分享，把同学们的问答通过专业标签划分的形式进行绑定，根据问答内容的点赞、收藏、转发的数量判定内容的好坏，精选属于该专业标签的优质问答内容，进而实现给用户推荐内容的效果。
用户注册和登录是本校园问答社区应该具备的基础功能。对于未注册登录的游客应具备基本的浏览、按搜索关键字问答内容的功能；对于登录授权的用户，拥有游客的功能，具备编辑发布问题，回答问题，分类查询专业百科和优质问答内容等功能。同时还应具备对问答内容的点赞、评论、分享、收藏等互动功能。
普通管理员对系统有管理校园问答社区用户与内容的权限。普通管理员根据超级管理员分配的权限，拥有登录系统，对微信用户，问答内容，评论内容，分类标签进行查找、修改、删除、更新的功能权限。
超级管理员拥有对所有管理员，用户，内容以及权限角色进行权限管理的功能。比如添加管理员，根据角色给予管理员权限，冻结用户，审核问答内容，系统管理，发布公告的功能。
除了功能性需求，系统还应保证可靠、安全、稳定、易操作性，再保证实现用户应有功能的前提下，还应给用户操作简单，方便使用、使用流畅的用户体验，同时对于用户的个人信息做好应有的安全工作。
## 3.2 系统功能需求
从3.1中的描述中，我们可以把本校园问答社区系统的主要功能分为系统管理、用户信息管理、问答内容管理、分类标签管理、以及互动信息管理等功能。进而分为以下五大功能模块：
（1）系统后台管理模块：超级管理员进入系统主界面，可以对普通管理员进行管理，增加、删除、更新、查询普通管理员的信息（普通管理员主要任务是审核用户提交的问答内容）；可以对系统用户权限进行管理；可以对系统硬件信息、系统日志进行查看。
（2）用户信息管理：进入微信小程序，用户点击登录授权后，用户可以通过个人信息页面查看个人信息；用户可以查看系统通知公告和本人提问与回答内容的审核信息。管理员可以进入后台界面对用户的信息查看，冻结管理。
（3）问答内容管理：用户进入微信小程序端主界面，可以根据不同的选项卡查看“全部”、“最新”、“推荐”的问答内容；用户可通过发布页面，选择发布内容类型“提问”或“回答”，进入不同的页面后，选择不同的标签并进行编辑发布富文本内容。管理员进入后台界面对用户所发的问答内容进行审核，审核通过的内容才予以在微信小程序端展示。
（4）分类标签管理：用户可以在微信小程序端点击不同标签查看当前标签对应的问答内容列表以及一些精选问答内容。管理员进入后台可以查看、创建、删除、更改标签信息。
（5）互动管理：用户可以对问答内容详情点赞、收藏、转发与评论，并可以在个人页面查看自己点赞、收藏、查看过的问答内容列表；管理员能进入后台管理系统进行相关问题的审核与查看。

## 3.3 非功能需求
### 3.3.1 环境需求
表1 环境需求表

| 操作系统 | Win10、 CentOS7 |
| --- | --- |
| 部署环境 | JDK、Mysql、Redis |
| 内存容量 | 8G以上 |
| 硬盘容量 | 40G以上 |

### 3.3.2 系统特征
为了提升系统质量， 提升系统运行效益， 同时使系统尽可能在各种环境下运行。 系统设计需要满足以下几个系统特性：
表2 系统特性表

| 交互性 | 系统遵循与用户习惯的一致性；对每一个操作都有清晰的反馈；前端界面设计有简单且直观的操作流程，界面语言表意明确且清晰；根据不同的场景给用户不同的操作建议与提示。 |
| --- | --- |
| 兼容性 | 本系统后台系统能兼容目前如Chrome、Firefox、Edge大部分主流浏览器显示；微信小程序端适应各个手机端型号。 |
| 健壮性 | 服务器有很好的稳定性，开发的每一个接口都进行严格的测试。 |
| 安全性 | 严格保护用户隐私信息不被泄露。根据用户的不同身份给予不同数据的查看、修改权限。 |
| 可扩展性 | 本系统采用SpringBoot作为基础框架，易扩展。 |
| 易操作性 | 系统界面要求简洁，主题突出，操作方面。 |


# 4.系统总体设计
## 4.1 系统架构设计

校园问答社区基于B/S结构，以SpringBoot作为主要架构，使用Mysql和Redis提供数据服务；使用SpringBoot整合SpringMVC和Mybatis，为微信小程序端和WEB后台提供统一的数据请求接口；选用基于Vue.js的前端框架uView+Element作为前端组件。本系统采用前后端分离模式，前端负责渲染从后端请求得到的数据和路由工作，后端根据前端请求执行业务逻辑并返回操作结果。整体系统架构如图所示：

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370837110-dacae428-401f-4030-a665-6155b7a4ef87.png#averageHue=%23f0e4d8&id=noMjD&originHeight=724&originWidth=761&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图7 系统架构图

各层含义与职责：

1. 应用层：本系统为了方便用户使用，前端主要分为WEB后台内容管理端和微信小程序端。该层主要基于Vue.js的一些前端框架编写前端程序，负责渲染从后端API请求得到的数据。
2. 业务层：该层只负责对具体问题进行逻辑与执行操作，对接收的数据进行逻辑处理，实现对数据的增加、删除、修改、更新等功能，并把根据业务逻辑执行的处理结果返回给前端。
3. 控制层：该层采用SpringMVC框架，实现对业务层和数据访问层进行松耦合。
4. 访问层：该层采用优秀的持久层框架MyBatis，通过其JavaAPI进行对Mysql数据库的操作。
5. 存储层：该层主要提供资源存储，数据存储服务。
6. 操作系统层：操作系统保证Mysql、Redis、文件系统的基础功能良好运行与实现。

各层之间之间的依赖被降低，相互独立但又各司其职，系统的安全性、可维护性、健壮性得到了提升和保障。

## 4.2 系统软件结构设计
本系统主要分为微信小程序端和WEB后台信息管理端。微信小程序端实现普通用户的编辑提交问题、回答问题、分类或根据关键字查询、点赞收藏分享一系列功能；WEB后台内容管理系统主要为系统管理员，CMS内容管理员实现对服务器和校园问答社区内容进行监管的功能实现。
### 4.2.1 微信小程序客户端软件结构设计
校园问答社区在微信小程序端共包含五大模块：用户信息管理模块、问答内容推荐模块、标签分类查看内容模块、问答内容编辑与发布模块、互动信息管理模块，如图8所示。
（1）用户信息管理模块：
该功能是用户登录之后查看个人信息。这里主要内容是把用户信息从出数据库中获得展示在页面上，可以对用户信息进行修改。
（2）问答内容推荐模块：
该功能主要在首页查询展示最新或点赞收藏多的问答内容，一共分为“全部”、“最新”、“推荐”三个模块。“全部”模块对数据库进行查找并展示在首页；“最新”模块对查询到的问答内容进行通过审核的时间查找排序展示在首页；“推荐”模块对查询到问答内容进行对问答内容的点赞收藏点踩内容进行排序并展示在首页。
（3）标签分类查看内容模块：
该功能是实现对问答内容打标签展示，标签主要分为学习和生活两大方面。学习类的标签是根据学院专业分类，生活标签是一些常见的自定义的标签。用户点击某一分类可以查看此标签下的百科内容以及相关的问答内容推荐。用户也可以进行关键字搜索，搜索问答内容进行查看。
（4）问答内容编辑与发布模块：
该功能模块是实现用户提问和回答内容的提交与发布。该模块应实现富文本编辑器，能使用户在短时间内编写出图文并茂的内容。保存的富文本内容可经过解析渲染展示在前端页面上。
（5）互动信息管理模块：

该功能模块是实现用户对问答内容的点赞、评论、收藏、分享操作。用户可以对自己喜欢的问答内容进行点赞、评论收藏操作[20]。对违规内容还可以进行投诉举报操作。系统这些用户操作信息进行处理，推荐优质问答内容，删除违规内容。同时用户的点赞收藏内容还会出现在自己的个人主页，方便其二次查看。
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370837313-cf135199-d037-479b-b86b-089719d34f78.png#averageHue=%23656565&id=HjjIX&originHeight=758&originWidth=873&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)


图8 微信小程序端功能结构图

### 4.2.2 Web后台软件结构设计
校园问答社区在WEB后台端拥有权限管理模块，用户管理模块，问答社区内容管理模块，系统管理模块四大模块，如图9所示。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370837500-1b0669ff-fd6b-406d-bd04-6185ce5ed36b.png#averageHue=%234d4d4d&id=R91xQ&originHeight=856&originWidth=825&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图9 WEB后台管理系统功能结构图

（1）系统权限管理模块：系统权限管理模块又分为部门管理、岗位管理、角色管理、管理员用户管理四个子模块。本后台系统支持设置管理员为不同部门、不同岗位、不同角色设置权限。根据角色自由给予用户不同的权限控制。超级管理员可以自定义普通管理员权限，在本系统中只需设置内容管理系统管理员对微信小程序数据包括对微信用户信息的管理。
（2）微信用户管理模块：经由微信小程序登录的微信用户是本系统的重要数据，超级管理员和CMS管理员可以对其信息进行按条件查找、修改操作。
（3）问答社区内容管理模块：该模块又分为问答内容审核模块、问答内容管理模块、分类标签模块三个子模块。其中问答内容审核模块是指管理员可以对用户提交的问题内容、回答内容进行审核，以免其发布不健康不合规的内容；问答内容信息管理模块是指管理员可以查看，修改，删除（逻辑删除）用户发布的内容；此外，管理员还可以对分类的标签进行查看、修改、增加、删除操作。
（4）系统管理模块：该模块分为系统日志管理模块和在线用户管理模块。管理员可以对系统产生的日志和在线用户模块进行查看分析以便查看系统运行情况。

## 4.3 数据库设计
根据具体需求抽象出数据类型，再到构建一个合理的表结构是一个好应用的重要基础[21]。本系统根据上述需求，选用了Mysql关系型数据库和Redis非关系型数据库，使用Mysql关系型数据库存储了用户表、问题表、回答表、评论表、专业分类标签表、消息表，点赞收藏表等表；使用Redis存储用户登录授权的token以及系统常用的系统设置参数，加快用户访问系统的响应速度，进而提高用户使用体验。
### 4.3.1 系统用户及用例图
本系统将有超级管理员、CMS管理员、普通用户和游客四种角色。下面分别介绍各角色的权限。
超级管理员具有本系统最高的权限，其权限如下表所示：
表3 超级管理员权限表

| 角色 | 功能模块 | 功能权限 |
| --- | --- | --- |
| 


超级管理员 | 普通用户管理模块 | 用户的冻结，用户权限管理 |
|  | CMS系统管理员 | CMS管理员的增加与删除，CMS管理员的权限角色分配 |
|  | CMS系统内容的管理 | 对内容系统的增加，删除，修改，查询 |

表2 CMS管理员权限表

| 角色 | 功能模块 | 功能权限 |
| --- | --- | --- |
| 

CMS系统管理员 | 问答内容模块 | 问答内容审核，问答内容的管理 |
|  | 用户信息管理模块 | 用户信息的管理，用户冻结 |

表4 普通用户权限表

| 角色 | 功能模块 | 功能权限 |
| --- | --- | --- |
| 


普通用户 | 问答模块 | 提出问题、编辑发布问题、点赞收藏分享问答内容、查找查看问答内容，根据关键字搜索问答内容，查看问答内容的评论 |
|  | 文件模块 | 文件的上传，删除上传文件 |

表5 游客权限表

| 角色 | 功能模块 | 功能权限 |
| --- | --- | --- |
| 游客 | 问答内容模块 | 查看问答内容，根据关键字搜索问答内容，查看问答内容的评论 |

根据以上描述，画出本校园问答社区系统用例图如下：
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370837973-67e49de8-637b-430b-9bcb-7c2c79516de3.png#averageHue=%23f6f6f6&id=MwAvE&originHeight=1249&originWidth=1002&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图10 需求分析用例图

### 4.3.2 实体描述及E-R图
（1）问答社区系统的E-R图描述了实体之间的联系，并给出了相应实体的属性。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370838269-b0522854-6def-49aa-bafa-f4fc8a12125d.png#averageHue=%23fcfbfa&id=DJrcp&originHeight=622&originWidth=759&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图11 系统管理模块数据库表ER图

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370838518-dad6d69c-6372-4b2a-9319-29b9c9b13a4b.png#averageHue=%23fdfcfb&id=yaCwe&originHeight=603&originWidth=750&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图12 微信小程序端数据库表ER图

（2）数据库表介绍：
表6 微信用户信息表

| 表名 | 描述 |
| --- | --- |
| C_user | 微信用户信息表 |
| C_questions | 问题表，存储用户提问内容 |
| C_answers | 回答表，用于存储用户回答问题的相关信息 |
| C_comments | 评论表，用于存储用户对回答评论的相关信息 |
| C_message | 消息表，用于存储用户之间的消息信息 |
| C_major | 专业表，用于存储问题回答内容的标签信息 |
| User_like_collection | 点赞收藏表，用于存储用户对问答内容的点赞收藏信息 |
| Sys_user | 管理员的信息表，用于存管理员的登录账号等相关信息 |
| Sys_dept | 部门信息表 |
| Sys_post | 岗位信息表 |
| Sys_role | 角色信息表 |
| Sys_user_post | 用户与岗位关联表 |
| Sys_user_role | 用户和角色关联表 |
| Sys_menu | 系统菜单权限表 |
| Sys_role_dept | 角色与部门关联表 |
| Sys_role_menu | 角色与菜单关联表 |
| Sys_logininfo | 系统访问信息表 |

### 4.3.3 数据库结构
表7 C_user表

| 名称 |  类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| id | Char(19) | Primary key | 用户ID |
| Openid | Varchar(128) | Not null | Openid |
| Nickname | Varcahr(10) |  | 用户昵称 |
| Sex | Bit(1) |  | 性别 |
| Avatar | Varcahr(128) |  | 头像 |
| School | Varcahr(128) |  | 学校 |
| Disabled | Bit(1) |  | 是否加入小黑屋（0代表未加入、1代表加入） |
| Deleted | Bit(1) |  | 逻辑删除（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表8 C_questions表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| id | Char(19) | Primary key | 问题ID |
| Uid | Char(19) | Not null | 发布人ID |
| Title | Varchar(128) |  | 问题标题 |
| Detail | Text |  | 问题详情 |
| Major | Varchar(19) |  | 所属专业标签 |
| Deleted | Bit(1) |  | 逻辑删除（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表9 C_answers表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Id | Char(19) | Primary key | 回答ID |
| Uid | Char(19) | Not null | 用户ID |
| Qid | Char(19) |  | 问题ID |
| Detail | Text |  | 回答详情 |
| Views | Int(10) |  | 浏览人数 |
| Comments | Int(10) |  | 评论数 |
| Likes | Int(10) |  | 点赞数 |
| Unlikes | Int(10) |  | 点踩数 |
| Label | Varcahr(10) |  | 回答标签 |
| Checked | Bit(1) |  | 审核与否（0代表未审核、1代表审核通过） |
| Deleted | Bit(1) |  | 逻辑删除（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表10 C_comments表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Id | Char(19) | Primary key | 评论ID |
| Uid | Char(19) | Not null | 用户ID |
| Aid | Char(19) |  | 回答ID |
| Detail | Varchar(255) |  | 评论详情 |
| Likes | Int(10) |  | 点赞数 |
| Unlikes | Int(10) |  | 点踩数 |
| Deleted | Bit(1) |  | 删除标志（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表11 C_message表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Mid | Char(19) | Primary key | 消息ID |
| Uid | Char(19) | Not null | 发布人ID |
| Send_uid | Char(19) |  | 消息接收人ID |
| Content | Varchar(128) |  | 消息内容 |
| Deleted | Bit(1) |  | 删除标志（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表12 C_major表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Id | Char(19) | Primary key | 专业标签ID |
| Name | Varchar(128) | Not null | 专业名称 |
| Imgurl | Varcahr(255) |  | 专业图片地址 |
| Deleted | Bit(1) |  | 删除标志（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表13 User_like_collection表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Id | Char(19) | Primary key | 收藏点赞信息ID |
| Aid | Char(19) | Not null | 回答ID |
| Like_uid | Char(19) |  | 点赞用户ID |
| Collection_uid | Char(19) |  | 收藏用户ID |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表14 Sys_user表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| User_id | Bigint | Primary key | 管理员用户ID |
| Dept_id | Bigint |  | 部门ID |
| User_name | Varcahr(30) | Not null | 用户账号 |
| Password | Varchar(100) |  | 密码 |
| Email | Varcahr(50) |  | 用户邮箱 |
| Phonenumber | Varcahr(11) |  | 手机号码 |
| Sex | Char(1) |  | 性别 |
| Avatar | Varchar(100) |  | 头像地址 |
| Status | Char(1) |  | 账号状态 |
| Deleted  | Char(1) |  | 删除标志（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表15 Sys_dept表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Dept_id | Bigint(20) | Primary key | 部门ID |
| Parent_id | Bigiint(20) | Not null | 父部门ID |
| Ancestors | Varcahr(50) |  | 祖籍列表 |
| Dept_name | Varchar(30) |  | 部门名称 |
| Order_nume | Int(4) |  | 显示顺序 |
| Status | Char(1) |  | 部门状态 |
| Deleted | Bit(1) |  | 删除标志（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表16 Sys_post表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Post_id | Bigint | Primary key | 岗位ID |
| Post_code | Varchar(64) | Not null | 岗位编码 |
| Post_name | Varcahr(50) |  | 岗位名称 |
| Post_sort | Int(4) |  | 显示顺序 |
| Status | Char(1) |  | 状态 |
| Create_by | Varcahr(64) |  | 创建者 |
| Update_by | Varcahr(64) |  | 更新者 |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表17 Sys_role表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Role_id | Bigint(20) | Primary key | 角色ID |
| Role_name | Varchar(30) | Not null | 角色名称 |
| Role_key | Varcahr(100) |  | 角色权限字符串 |
| Role_sort | Int(4) |  | 显示顺序 |
| Datascope | Char(1) |  | 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限） |
| menu_check_strictly | tinyint(1) |  | 菜单树选择项是否关联显示 |
| dept_check_strictly | tinyint(1) |  | 部门树选择项是否关联显示 |
| status | char(1) |  | 角色状态（0正常 1停用） |
| Deleted | char(1) |  | 删除标志（0代表存在、1代表删除） |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表18 Sys_user_post表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| user_id | bigint(20) | Primary key | 管理员用户ID |
| Post_id | Bigint(20) | Not null | 岗位ID |

表19 Sys_user_role表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| User_id | Bigint(20) | Primary key | 管理员用户ID |
| Role_id | Bigint(20) | Not null | 角色ID |

表20 Sys_menu表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| menu_id | bigint(20) | Primary key | 菜单ID |
| menu_name | Varchar(50) | Not null | 菜单名称 |
| parent_id | bigint(20) |  | 父菜单ID |
| order_num | Int(4) |  | 显示顺序 |
| path | Varcahr(200) |  | 路由地址 |
| component | Varcahr(255) |  | 组件路径 |
| menu_type | Char(1) |  | 菜单类型（M目录 C菜单 F按钮） |
| visible | Char(1) |  | 菜单状态（0显示 1隐藏） |
| status | Char(1) |  | 菜单状态（0正常 1停用） |
| perms | Varchar(100) |  | 权限标志 |
| icon | Varchar(100) |  | 菜单图标 |
| create_by | Varchar(64) |  | 创建者 |
| update_by | Varchar(64) |  | 更新者 |
| create_time | datetime | 默认为当前时间 | 创建时间 |
| update_time | datetime | 默认为当前时间 | 修改时间 |

表21 Sys_role_dept表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Role_id | Bigint(20) | Primary key | 角色ID |
| Dept_id | Bigint(20) | Not null | 部门ID |

表22 Sys_role_menu表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| Role_id | Bigint(20) | Primary key | 角色ID |
| Menu_id | Bigint(20) | Not null | 菜单ID |

表23 Sys_logininfo表

| 名称 | 类型 | 限制 | 描述 |
| --- | --- | --- | --- |
| info_id | Bigint(20) | Primary key | 访问ID |
| user_name | Varchar( 50) | Not null | 用户账号 |
| Ipaddr | Varcahr(50) |  | 登录IP地址 |
| Login_location | Varchar(255) |  | 登录地点 |
| Browser | Varcahr(50) |  | 浏览器类型 |
| Os | Varcahr(50) |  | 操作系统 |
| Status | Char(1) |  | 登录状态（0成功 1失败） |
| msg | Varchar(255) |  | 提示消息 |
| Login_time | datetime |  | 访问时间 |


# 5.系统设计及实现
以上几章从本系统平台的需求分析、技术选型、数据库设计、系统架构设计等方面进行的阐述。本章针对上述内容进行具体的实现说明与结果展示。

## 5.1 开发环境与工具
### 5.1.1 开发环境

操作系统：Windows10
系统位数：64位
处理器：AMD A10-9600P 2.4GHz
系统内存：12G
硬盘：128G固态硬盘、500G机械硬盘
数据库服务器：Mysql10.1、Redis3.2.100

### 5.1.2 开发工具

系统开发语言：Java、vue.js、HTML，CSS，JavaScript
使用工具：Intellij IDEA、Redis Desktop Manager、Navicat、HbuilderX、微信小程序开发工具、Microsoft Edge浏览器、Git项目版本管理工具
前端框架：uView UI、Element UI、uni-app
后端框架：SpringBoot2.1.1、SpringMVC、Spring Security、Mybatis

## 5.2 后端接口设计实现

系统后端选用基于Java语言的SpringBoot框架进行开发，运用MySQL关系型数据库和Redis非关系型数据库，采用MVC视图控制器分离模型开发RESTful风格后端数据调用接口，整合Spring Security做JWT认证和授权。
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370838793-6cf6329c-929f-410a-8896-cdaba1dd5b44.png#averageHue=%23f8f7f6&id=PCxYE&originHeight=357&originWidth=284&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图13 后端项目目录结构图

## 5.3 微信小程序端的设计实现


小程序端主要为用户提供提交问题，回答问题，查看问题以及一些互动操作的功能。分别有登录授权功能、编辑提交问答功能、查看问答内容功能、查看消息公告和个人信息管理功能。本小程序基于uni-app的UI组件和uview UI组件进行开发，下面进行具体实现描述和结果展示。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370839248-1b8e28e9-bca0-43de-8e99-80d8a9471575.png#averageHue=%2322272e&id=jtxqN&originHeight=527&originWidth=280&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图14 微信小程序结构示意图
### 5.3.1 登录授权功能实现
因为基于微信小程序开发平台，本系统结合微信登录授权和JWT授权进行快速开发，避免了不必要的开发成本，方便用户使用。用户首次启动小程序并授权，开发者服务器获取用户信息并存入MySQL数据库，开发者服务器根据所获得信息自定义用户登录状态，返回token，完成登录授权。
具体过程如下：

1. 用户初次登陆，提醒用户点击了授权按钮，通过调用wx.login接口获得code，并携带发送请求到开发者服务器。
2. 开发者服务器携带小程序的appid、appsercret和微信小程序端获得的code，发送给微信的后台服务接口，得到session_key、openid和用户信息，把得到的用户信息存入数据库MySQL中，并通过用户信息生成token存入缓存数据库Redis中，返回给微信小程序生成的token，以后后端从微信小程序发送来的请求中依据token判别用户是否登录授权，以此来控制用户的权限访问。
3. 前端根据服务器返回信息设定全局变量“needAuth”和“isLogin”，访问其他界面便不会进行授权请求。至此用户登录授权功能得以实现。
4. 开发者服务器在以后的业务请求中只需校验token值中是否存在用户信息，存在则返回执行结果，反之返回权限问题。
5. 微信小程序处理渲染从服务端得到的结果

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370839500-9d4efc80-8ce8-4ba1-bdf1-22dc9ffccebe.png#averageHue=%23212121&id=E3AYo&originHeight=917&originWidth=984&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图15 微信小程序登录授权示意图

微信小程序用户授权实现结果如图16所示：

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370839733-968004a6-6e1c-4f8f-9375-06b0d0f020ad.png#averageHue=%23bab9b9&id=dt0Ft&originHeight=504&originWidth=862&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图16 用户登录授权流程图

### 5.3.2 问答功能实现
#### 5.3.2.1 富文本编辑器
时代在快速发展，人们对编辑器的需求也逐渐提高。实现具有可见即所得特点的富文本编辑器，让用户在短时间内能够完成一篇精美的文章成为了内容平台的强烈功能需求[22]。为了使用户在提问和回答的时候更加方便输入样式丰富的文字、上传本地图片以及查看问答内容时可以看到更多丰富多彩的文章，本校园问答社区实现了富文本编辑器的功能，可以给予字体加粗、倾斜、下划线，标题样式，左对齐，右对齐和插入上传图片，插入分割线等功能，增加了用户体验。编辑器实现的流程为：编辑器提供样式选择，用户先选择样式，然后输入内容，提交内容时会携带内容HTML样式，提交后的HTML片段内容保存在MySQL中；当用于查阅相关内容时，服务器从数据库中把内容取出，前端根据内容渲染内容呈现。如下图所示：
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370839997-bf8c60ab-8374-48ca-85db-ca4cc8d1f8fe.png#averageHue=%23f5f2f1&id=EPjeb&originHeight=508&originWidth=288&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图17 富文本编辑器页面展示图

#### 5.3.2.2 图片上传功能
在富文本编辑器中，插入图片时调用uniCloud云存储提供的API把本地图片自动上传到云存储的服务器，返回了图片URL链接，富文本编辑器赋予其样式，在内容提交时，图片标签同编辑器内容一并提交到数据库进行存储。

#### 5.3.2.3 智能内容安全审核实现
网络不是法外之地，然而越来越多的色情、涉政、暴恐、宗教煽动等内容出现在互联网上，不仅损害用户的上网体验，还在一定程度上扰乱社会秩序，危害国家安全[23]。构建健康和谐的网络环境，用户有维护绿色网路的义务，同时系统开发者也应去限制用户的恶意行为。从以往到现在，提供内容的平台多采用人工审核的机制，但因为内容繁多，审核人员的手动审核内容，不仅增加了维护成本，还因为效率低下，降低了用户体验。目前许多云服务提供商多提供内容安全检测接口可以极大的自动审核内容，克服了以往耗费人力物力的缺点。但内容安全检测算法也是会存在误判的现象。所以结合人工和内容检测算法，先让内容安全检测算法审核用户提交内容，审核的管理员根据实际情况查看或更改审核结果。从而达到了内容审核速度快且少误判。
本系统采用二者兼有的模式。通过接入阿里云内容安全检测接口，实现了内容安全检测功能。即当用户提交提问和回答内容之后，系统自动进入对文本的检测，检测其是否有色情、涉政、暴恐等风险。则该内容进入人工审核阶段，并提示用户“提交成功，待审核”。若提交内容无误，则该内容直接审核通过。用户可以在消息页面查看提问和回答内容的审核状态。
部分代码流程截图：

| if (save == true) { //提交内容保存成功
    if(aliyunOssController.textFilter(answer.getAnswer())){ //调用阿里云内容检测网络API检测提交的问题回答内容，true通过，false为不通过。
        cAnswers.setChecked(true);   //设置问题内容审核状态为true
        return R.success("提交成功，审核成功"); //返回给用户提示信息
    }
    return R.success("提交成功，待审核"); //没有通过自动检测算法，则进入待审核状态
} else {
    return R.error("提交失败");
} |
| --- |


用户授权登录以后，可以选择“提问”、“回答”模块如下图所示。用户选择“提问”功能，进入提问编辑页面，输入问题标题，标签分类和详细描述并提交发布，发布成功则进入审核。内容审核分为人工审核和内容检测算法审核两种，提交的内容先经过阿里云内容检测接口检测，检测通过，则内容审核通过，并给用户提示“提交成功，待审核”；若审核没有通过，则进入人工审核流程，内容管理员查看内容审核其是否合规，决定其审核是否通过。
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370840260-23f37fe8-2576-429c-af80-d825de94a3fa.png#averageHue=%23f7f6f5&id=tr8Qs&originHeight=505&originWidth=1147&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图18 提问回答功能展示图


### 5.3.3 问答内容分类展示功能
**（1）最新、推荐内容查看：**
在小程序首页，选择头部不同的导航栏实现查看最新或推荐的问答内容。最新问答内容根据发表审核通过时间排序，推荐内容根据其他用户对问题回答的点赞、收藏情况进行排序。用户点击具体的每一条问答内容，进入该内容的问题解答详情界面查看具体内容。在此页面可以对回答内容进行点赞、评论、收藏、转发操作。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370840547-cdf5134d-7743-4ac5-87f9-b9f96e1efe64.png#averageHue=%23c6c3c2&id=h8r4V&originHeight=508&originWidth=576&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图19 最新、推荐内容查看图

**（2）按分类标签查看：**
在分类标签页面中，用户可以点击某一具体分类内容进行查看该标签的百科内容和热点问答内容。通过点击每一条问答推荐，都会跳到问题解答详情页面进行查看详情，并进行点赞、评论、收藏、转发操作。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370841030-cd7dc17d-777f-405f-b5b9-870e000a94cd.png#averageHue=%23f4f3f3&id=y6JwG&originHeight=507&originWidth=575&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图20 按标签查看问答内容图

### 5.3.4 消息公告功能实现
在消息页面，用户可以查看系统公告和提交的提问和回答内容的审核情况。如下图所示：

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370841347-ebeb72cd-fe17-40ba-8747-2aa0f7c7f5c1.png#averageHue=%23f5f4f4&id=UR0D7&originHeight=509&originWidth=1148&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图21 消息公告页

### 5.3.5 个人信息管理功能

为了加强用户之间的联系以及推选出某一问题的优质答案，小程序实现了对回答内容进行点赞、收藏、转发、评论的互动功能。同时用户有对优质问答内容点赞收藏之后再次查看的需求，所以系统设计了相应的功能，方面用户对优质问答内容进行分类查看。如图所示：
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370841604-3ca7db4e-b9cb-40a8-8544-a54ec2dd1961.png#averageHue=%23cfb68b&id=sU2JA&originHeight=506&originWidth=852&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图22 个人点赞、收藏列表页面

## 5.4 Web后台（CMS）内容管理系统
Web后台采用基于Vue.js的Element基础框架组件进行开发，主要分类四个大模块，分别为管理用户权限功能模块、微信用户管理功能功能、校园问答社区管理功能系统管理功能模块，下面进行具体实现描述和结果展示。
后台项目目录结构：

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370841795-3a4c1bcb-b678-45be-82dc-0ad4d1ed13b4.png#averageHue=%2322272e&id=NlHYM&originHeight=535&originWidth=286&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图23 后台系统项目结构图

### 5.4.1 系统权限管理功能实现
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370842056-184f3b18-4802-444e-b048-d95fd5947abf.png#averageHue=%239c7155&id=HUD84&originHeight=466&originWidth=1007&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
图24 管理员登录界面

超级管理员登录进入后台管理界面后，选择“系统管理”下的“用户管理”进行对普通管理员进行权限管理。角色权限管理模块又分为：部门管理，岗位管理和角色管理。以下是超级管理员操作界面截图：
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370842435-237a50a4-e0b0-4f8a-8adc-077afef999c7.png#averageHue=%23e3b08c&id=BMt5j&originHeight=630&originWidth=1366&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图25 部门信息管理图

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370842684-84af5b8b-e74c-41c4-a862-661f516e191e.png#averageHue=%23eab56e&id=HWbxj&originHeight=630&originWidth=1362&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图26 岗位信息管理图

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370842914-cd67a5c3-6528-44ae-bf79-b71b63d98f60.png#averageHue=%23e8c379&id=gsKTf&originHeight=629&originWidth=1362&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图27 角色管理图

### 5.4.2 微信用户管理功能实现
超级管理员和普通管理员登录进入系统之后，可以选择对小程序的微信用户信息进行管理：按条件查询、修改、删除用户信息。
实现结果如下：
![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370843139-7ba01c5b-cb00-401e-ba56-e1b07130ab29.png#averageHue=%23eab168&id=quFgS&originHeight=627&originWidth=1363&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图28 微信用户管理图

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370843349-07d3fa58-98ac-41e4-9565-4737bd2d98df.png#averageHue=%23b2b1b1&id=YGGcr&originHeight=629&originWidth=1366&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图29 修改微信用户信息图

### 5.4.3 校园问答社区管理功能实现
校园问答社区管理，主要是提供给管理员对用户提交的问题内容和回答内容进行审核，管理员通过选择查看经过内容安全检测算法没有检测通过的问答内容，人工审核看其是否符合规范决定审核是否通过；除此以外，还提供了对回答评论，导航标签，专业分类标签，文件上传表的增加、删除、更新、多字段查找的完备功能。


如下图所示：

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370843604-65b216fe-9f58-4eb7-bdb6-0b2226ebaadc.png#averageHue=%236d605a&id=oPxOy&originHeight=435&originWidth=930&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图30 审核问题内容图

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370843868-e605f9af-f5d6-4c07-a5b0-c0130a6a07e9.png#averageHue=%23e9b673&id=If8so&originHeight=625&originWidth=1366&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图31 用户问答管理图

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370844087-f9765f13-f932-4658-a62f-5a5b497137e0.png#averageHue=%23d7ba7b&id=fK9HM&originHeight=630&originWidth=1364&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图32 根据搜素字段查找问答图

### 5.4.4 系统管理功能实现
系统管理模块：实现了系统菜单管理、系统字典管理、参数设置、日志管理等功能，以界面化的方式提供系统的基础设置功能。系统菜单管理功能实现了菜单的隐藏、排序等功能。系统界面参数设置功能实现了系统界面风格的调整。日志管理功能详细记录了包括登录 IP、操作人、操作模块及执行操作等各类日志信息。

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370844317-99211555-0443-4211-ae6a-35a37f1894b5.png#averageHue=%23e7c489&id=eTaZ7&originHeight=628&originWidth=1347&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图33 操作日志图

![](https://cdn.nlark.com/yuque/0/2021/png/1143997/1634370844577-27c66137-da88-4527-9d10-86d71266cd5a.png#averageHue=%23eccb88&id=ECJlM&originHeight=631&originWidth=1361&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)

图34 用户登录日志图


# 总结
社交性的校园问答社区服务是大数据时代的产物，与传统依靠搜索引擎寻求答案方式不同，它提供了人们在某一问题上的更加全面深刻多样的答案，极大加快了人们寻求答案的速度。本文在调研了传统架构技术后，选用了比较轻量级的SpringBoot技术框架和Vue技术框架开发实现了一个致力于为在校大学生提供分享知识、经验、见解的校园问答社区。本文的主要工作涵盖了以下方面：
本文进行调研阐述了校园问答社区的研究背景，了解了当下国内对问答社区的研究现状，从而阐述出项目的实施意义。同时也说明了开发本系统的所有技术选型原因，采用SpringBoot后端框架和Vue前端框架实现前后端分离不仅能使开发系统的各个模块实现解耦，还能在提高服务端系统性能前提下缩短系统开发周期。
在系统设计与实现上，我主要从需求分析、系统 总体设计、数据库 设计和系统详细设计与 实现等内容逐一阐述。 最终设计出拥有WEB后台管理系统和微信小程序端的多端系统应用。为了提高不同用户（管理员，用户）的使用体验，我们从内容和性能方面对平台进行了优化：
内容上：本系统对用户提交的问题、回答内容采用内容安全自动审核机制，用户一经提交问题或回答，后端收到之后将对其内容进行检测，若其内容没有违规则甚至问答内容审核状态为审核通过；若其内容疑似违规，该内容只能等待CMS管理员的审核。这样的机制大大加快内容安全审核的速度，不仅减少了管理员的工作量，还提升了用户体验。
性能上：除了采用基于RESTful接口设计风格实现前后端分离开发与部署，我们还使用了Redis非关系型数据库实现缓存。选用Redis作为缓存服务器，Mysql服务器的负载压力被大大减轻，提升系统的性能。
得益于前后端分离开发方式和JWT认证授权机制，本系统实现了微信小程序端和WEB后天系统可以同一套后端接口，并且能稳定运行，各模块之间相互协作，最终实现了基于SpringBoot的校园问答社区系统的设计与开发。
基于SpringBoot的校园问答社区系统是一个加强在校大学生沟通交流知识、经验、见解的校园问答社区系统，为了能让用户拥有更好的使用体验，系统还需完善以下内容：
1、微信小程序端可以进一步完善问答内容推荐模块，根据用户的互动日志生成个性化推荐内容，以便用户快速获得需求模糊的问答内容。
2、线上部署，并增加系统测试用例，确保线上系统平稳运行。

参考文献
[1] 陶雪娇,胡晓峰,刘洋. 大数据研究综述[J]. 系统仿真学报, 2013, 25(S1): 142-146.
[2] 邬贺铨. 大数据时代的机遇与挑战[J]. 求是, 2013, 593(4): 47-49.
[3] 宋文丹. 社会化问答社区的社会网络分析[D]. 西南交通大学, 2015.
[4] 王飞翔. 数据挖掘技术在问答社区中的应用[D]. 南京邮电大学, 2018.
[5] Nwadiugwu martin c.,Nwadiugwu cynthia c.. Influencing Followership: Understanding the Perspective of Those Leading Active Discussions on Quora[J]. Frontiers in Computer Science, 2021.
[6] 贾诗琦. 社交问答平台相关研究综述[J]. 内蒙古科技与经济, 2015, 340(18): 81-83, 85.
[7] 王哲. 社会化问答社区知乎的用户持续使用行为影响因素研究[J]. 情报科学, 2017, 35(1): 78-83, 143.
[8] 逯越琛. 信息化时代大学生获取就业信息途径分析[J]. 品牌(下半月), 2014(12): 125.
[9] Design of Man Hour Management Information System on SpringBoot Framework[J].
[10] 吕宇琛. SpringBoot框架在web应用开发中的探讨[J]. 科技创新导报, 2018, 15(8): 168, 173.
[11] 董巧琪. APP用户反馈信息分析系统的设计与实现[D]. 北京交通大学, 2020.
[12] Li ma. Data Persistence on Curriculum Management System based on MyBatis[C]//Proceedings of 2016 2nd International Conference on Economics,Social Science,Arts,Education and Management Engineering(ESSAEME 2016): Atlantis Press, 2016: 770-774.
[13] 何军,陈倩怡. Vue+Springboot+Mybatis开发消费管理系统[J]. 电脑编程技巧与维护, 2019, 404(2): 87-88, 102.
[14] 王志文. Vue+Elementui+Echarts在项目管理平台中的应用[J]. 山西科技, 2020, 35(6): 45-47.
[15] 李宇,刘彬. 前后端分离框架在软件设计中的应用[J]. 无线互联科技, 2018, 15(17): 41-42.
[16] 龚凡. 基于Spring Security的Web系统安全模块的设计与实现[D]. 华中科技大学, 2011.
[17] 林嘉婷. 试谈前后端分离及基于前端MVC框架的开发[J]. 电脑编程技巧与维护, 2016, 365(23): 5-8.
[18] 陈宇收,饶宏博,王英明,等. 基于JWT的前后端分离程序设计研究[J]. 电脑编程技巧与维护, 2019, 411(9): 11-12.
[19] 浅谈软件项目开发过程中的需求分析[J].
[20] 邓笑. 基于Spring Boot的校园轻博客系统的设计与实现[D]. 华中科技大学, 2018.
[21] 焦鹏珲. 基于SpringBoot和Vue框架的电子招投标系统的设计与实现[D]. 南京大学, 2018.
[22] 汪蓉. HTML在线文本编辑器在Java web开发中的使用分析——以KindEditor为例[J]. 湖北科技学院学报, 2013, 33(6): 21-23.
[23] 刘华鹏,刘胜全,刘艳,等. 基于语义的Web内容安全检测模型[J]. 计算机工程与应用, 2014, 50(14): 116-120.

# 

