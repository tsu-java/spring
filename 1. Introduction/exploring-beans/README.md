# Exploring Beans

აქ არის მოვყანილი Bean-ების აღწერისა და გამოყენების მარტივი მაგალითები. ასევე ვეხებით Dependency Injection-ს
მექანიზმსაც (ან ინექციას, როგორც მას მეორენაირად ეძახიან).

არ დაგავიწყდეთ, ბინები იქმნება და იმართება Spring Container-ის მიერ, რომელიც პროგრამულად იგივეა რაც ApplicationContext
(ან BeanFactory) ობიექტი. მისი დახმარებით შეგვიძლია ბინები ავიღოთ და აღვწეროთ კიდევაც (ხელით).

ხელით ბინების აღწერის მაგალითი აქ მოყვანილი არ მაქვს, რადგანაც ჩავთვალე რომ ზედმეტი იქნებოდა. მხოლოდ ანოტაციებზე
დაფუძნებული ბინების კონფიგურაციის მაგალითებია წარმოდგენილი. ეს მიდგომა დეფაქტო სტანდარტივითაა დღეს და ჩვენც ანოტაციებით
კონფიგურაციას გამოვიყენებთ ახლაც და მომავალშიც.

გახსოვდეთ, არსებობს ApplicationContext-ის ბევრნაირი იმპლემენტაცია, მაგრამ ძირითადად გამოიყენება შემდეგი ტიპის იმპლემენტაციები:

- StaticApplicationContext - ბინების აღწერა და გამოყენება ამ დროს ხელით მოგიწევთ.
- ClassPathXmlApplicationContext ან FileSystemXmlApplicationContext - ბინები ამ დროს აღიწერება XML ფაილებში.
- AnnotationConfigApplicationContext - ბინები აღიწერება ანოტაციების მეშვეობით.
- და ა.შ. სია დიდია, მაგრამ სხვა ყველა დარჩენილი კონტეინერის ვარიანტი მუშაობს წინა სამის მსგავსად.

პ.ს. Spring Boot-ის გამოყენების შემთხვევაში ჩვენ ხელით მაინც არ გვიწევს ApplicationContext ობიექტის შექმნა. მას გვიქმნის
SpringApplication კლასის run(..) მეთოდი. ასე რომ, დიდად ნუ იდარდებთ. კონტექსტის შექმნა მხოლოდ იმ შემთხვევაში მოგიწევთ თუ
სპრინგის IoC მექანიზმის ჩაშენება გსურ ცალკე აპლიკაციაში, რომელშიც იგი არ გამოიყენება: JavaFX-ში, Servlet/JSP
აპლიკაციაში და ა.შ.