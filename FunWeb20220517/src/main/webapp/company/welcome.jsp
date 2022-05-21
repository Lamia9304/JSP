	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../css/style.css" type="text/css" />
<script
      src="https://kit.fontawesome.com/9eb162ac0d.js"
      crossorigin="anonymous"
    ></script>

<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->

<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
 
</head>
<body>
<div id="wrap">
<!-- 헤더가 들어가는 곳 -->
<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더가 들어가는 곳 -->

<!-- 본문 들어가는 곳 -->
<!-- 서브페이지 메인이미지 -->
<div id="sub_img"></div>
<!-- 서브페이지 메인이미지 -->
<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<!-- <ul>
<li><a href="#">Welcome</a></li>
<li><a href="#">History</a></li>
<li><a href="#">Newsroom</a></li>
<li><a href="#">Public Policy</a></li>
</ul> -->
</nav>
<!-- 왼쪽메뉴 -->
<!-- 내용 -->
<article>
 

    <!-- Home -->
    <section id="home">
      <div class="home__container">
        <img
          src="../imgs/profile.jpg"
          alt="Jang won's profile photo"
          class="home__avatar"/> 
        <h1 class="home__title">Hello, <br /><br/>My name is Jang Won Seo</h1>
        <h2 class="home__description">
            Aiming to be the best programmer  
        </h2>
        <button class="home__contact" data-link="#contact">Contact Me</button>
      </div>
    </section>

    <!-- About -->
    <section id="about" class="section section__container">
      <h1>About me</h1>
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure possimus
        rem sequi? Nihil, est impedit dignissimos consequatur totam, odit
        deserunt doloremque laudantium similique corrupti, iusto optio rerum in
        deleniti officia.
      </p>
      <div class="about__majors">
        <div class="major">
          <div class="major__icon">
            <i class="fab fa-html5"></i>
          </div>
          <h2 class="major__title">Front-end</h2>
          <div class="major__description">
            HTML, CSS, JavaScript
            
          </div>
        </div>
        
        <div class="major">
          <div class="major__icon">
            <i class="fas fa-server"></i>
          </div>
          <h2 class="major__title">Back-end</h2>
          <p class="major__description">
            Java, JavaScript,Jsp,Spring
           
          </p>
        </div>
      </div>
      <div class="about__jobs">
        <div class="job">
      </div>
    </section>

    <!-- Skills -->
    <section id="skills" class="section">
      <div class="section__container">
        <h1>Skills</h1>
        <h2>Skills & Attributes</h2>
        <p>
          Experience with all phases of the software life-cycle. Passion for
          learning new technologies. Capable of working within a team environment
          and independently. Ability to plan and time schedule, work under strict
          time pressure and adapt quickly when needed.
        </p>
        <div class="skillset">
          <div class="skillset__left">
            <h3 class="skillset__title">Skills</h3>
            <div class="skill">
              <div class="skill__description">
                <span>HTML</span>
                <span>99%</span>
              </div>
              <div class="skill__bar">
                <div class="skill__value" style="width: 99%;"></div>
              </div>
            </div>
            <div class="skill">
              <div class="skill__description">
                <span>CSS</span>
                <span>90%</span>
              </div>
              <div class="skill__bar">
                <div class="skill__value" style="width: 90%;"></div>
              </div>
            </div>
            <div class="skill">
              <div class="skill__description">
                <span>JavaScript</span>
                <span>90%</span>
              </div>
              <div class="skill__bar">
                <div class="skill__value" style="width: 90%;"></div>
              </div>
            </div>
            <div class="skill">
              <div class="skill__description">
                <span>Java</span>
                <span>80%</span>
              </div>
              <div class="skill__bar">
                <div class="skill__value" style="width: 80%;"></div>
              </div>
            </div>
            <div class="skill">
              <div class="skill__description">
                <span>Jsp</span>
                <span>88%</span>
              </div>
              <div class="skill__bar">
                <div class="skill__value" style="width: 88%;"></div>
              </div>
            </div>
            <div class="skill">
              <div class="skill__description">
                <span>Spring</span>
                <span>77%</span>
              </div>
              <div class="skill__bar">
                <div class="skill__value" style="width: 77%;"></div>
              </div>
            </div>
          </div>
          <div class="skillset__right">
            <div class="tools">
              <h3 class="skillset__title">Tools</h3>
              <ul class="tools__list">
                <li><span>Visual Studio Code</span></li>
                <li><span>IntelliJ</span></li>
                <li><span>Eclipse</span></li>
               
              </ul>
            </div>
            <div class="etc">
              <h3 class="skillset__title">Etc</h3>
              <ul class="etc__list">
                <li><span>Git</span></li>
                
              </ul>
            </div>
          </div>
      </div>
    </section>

    <!-- Work -->
    <section id="work" class="section">
     <div class="section__container">
      <h1>My work</h1>
      <h3>Projects</h3>
      <div class="work__categories">
        <button class="category__btn selected" data-filter="*">
          All <span class="category__count">6</span>
        </button>
        <button class="category__btn" data-filter="front-end" data-filter="front-end">
          Front-end <span class="category__count">3</span>
        </button>
        <button class="category__btn" data-filter="back-end" data-filter="back-end">
          Back-end <span class="category__count">3</span>
        </button>
      
      </div>
      <div class="work__projects">
        <a href="" class="project" target="blank" data-type="front-end">
          <img
            src="../imgs/projects/project1.png"
            alt="Youtube"
            class="project__img"
          />
          <div class="project__description">
            <h3>Youtube Site</h3>
            <span>Clone coding with HTML, CSS</span>
          </div>
        </a>
        <a
          href="https://github.com/Lamia9304/Responsive_header"
          class="project"
          data-type="front-end"
          target="blank"
        >
          <img
            class="project__img"
            src="../imgs/projects/project2.png"
            alt="navbar"
          />
          <div class="project__description">
            <h3>Responsive Navbar</h3>
            <span>HTML, CSS with media query</span>
          </div>
        </a>
        <a
          href="https://github.com/Lamia9304/Shopping-mall"
          class="project"
          data-type="front-end"
          target="blank"
        >
          <img class="project__img" src="../imgs/projects/project3.png"alt="navbar" />
          <div class="project__description">
            <h3>Shopping mall game</h3>
            <span>HTML, CSS, JavaScript, Json</span>
          </div>
        </a>
        <a href="https://github.com/Lamia9304/JSP" class="project" data-type="back-end">
          <img class="project__img" src="../imgs/projects/project4.png" alt="" />
          <div class="project__description">
            <h3>JSP 게시판</h3>
            <span>Explanation</span>
          </div>
        </a>
        <a href="" class="project" data-type="back-end">
          <img class="project__img" src="../imgs/projects/project5.png" alt="" />
          <div class="project__description">
            <h3>Project</h3>
            <span>Explanation</span>
          </div>
        </a>
        <a href="" class="project" data-type="mobile">
          <img class="project__img" src="../imgs/projects/project6.png" alt="" />
          <div class="project__description">
            <h3>Project</h3>
            <span>Explanation</span>
          </div>
        </a>
        <a href="" class="project" data-type="mobile">
          <img class="project__img" src="../imgs/projects/project7.png" alt="" />
          <div class="project__description">
            <h3>Project</h3>
            <span>Explanation</span>
          </div>
        </a>
        <a href="" class="project" data-type="mobile">
          <img class="project__img" src="../imgs/projects/project8.png" alt="" />
          <div class="project__description">
            <h3>Project</h3>
            <span>Explanation</span>
          </div>
        </a>
      </div>
     </div>
    </section>

    <!-- Testimonials -->
    <section id="testimonials" class="section">
   <div class="section__container">
    <h1>Testimonials</h1>
    <h3>See what they say about me</h3>
    <div class="testimonials">
      <div class="testimonial">
        <img
          src="../imgs/testimonials/people1.jpg"
          alt="People"
          class="testimonial__avatar"
        />
        <div class="../testimonial__speech-bubble">
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque
            fuga libero nulla eveniet aperiam laborum, quis provident
            quibusdam officiis reprehenderit, placeat neque perspiciatis vero
            explicabo tempora, dignissimos accusantium inventore ducimus!
          </p>
          <p class="name"><a href="">Jang Won</a></p>
        </div>
      </div>
      <div class="testimonial">
        <div class="testimonial__speech-bubble">
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque
            fuga libero nulla eveniet aperiam laborum, quis provident
            quibusdam officiis reprehenderit, placeat neque perspiciatis vero
            explicabo tempora, dignissimos accusantium inventore ducimus!
          </p>
          <p class="name"><a href="">Jang Won</a></p>
        </div>
        <img
        src="../imgs/testimonials/people1.jpg"
        alt="People"
        class="testimonial__avatar"
      />

      </div>
    </div>
   </div>
    </section>

    <!-- Contact -->
    <section id="contact" class="section">
      <h1 class="contact__title">Let's talk</h1>
      <h2 class="contact__email">kanoring9304@gmail.com</h2>
      <div class="contact__links">
        <a href="https://github.com/Lamia9304" target="_blank">
          <i class="fab fa-github"></i>
        </a>
        <a href="#" target="_blank">
          <i class="fa fa-linkedin-square"></i>
        </a>
      </div>
      <p class="contact__rights">
        2022  Jang Won - All rights reserved
      </p>
    </section>

    <!-- Arrow up -->
    <button class="arrow-up">
      <i class="fas fa-arrow-up"></i>
    </button>
<!-- 내용 -->
<!-- 본문 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳 -->
</div>
</body>

 <script src="../js/main.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>



    