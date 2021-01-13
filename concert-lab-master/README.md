Concert Assemble
===

- присутній інтерфейс і його імплементація (1 бал) :

    interface Performable - Artist

- присутній поліморфізм (1 бал):

    interface Performable, метод perform()

    Dancer, метод perform()

- Перевизначити метод toString() для класу enum. Наприклад, виводити всі значення у одну строчку розділяючи комою.  Додати до перерахування власний метод.Використати обидва методи у програмі.

    enum InstrumentType, додатковий метод printDescriptionsList()

- Зібрати строку за допомогою StringBuffer або StringBuilder:

    Main, 62 строка

- Використати метод String.split(...) для розділення строки за критерієм обраного символу. (1 бал) :

    Dancer 12 строка

- Вивести деякі строки на екран консолі із використанням конкатенції строк із іншими типами (1 бал):

    Concert 60 строка

- Створити клас-виключення для обробки специфічної для вашої тематики помилки. (1 бал) 

    NotPerformableException

- Кидати вами створену помилку та інші за необхідності, обробляти їх у влучному місці за допомогою блоку try-catch-finally (1 бал) 

    кидається Dancer 34 строка, ловиться Main 66 строка

- Використати неперевизначений метод equals або hashCode для порівняння двох об’єктів одного з ваших класів. (1 бал) 

    клас Main 31 строка

- Перевизначити метод equals або hashCode у одному з ваших класів, використати перевизначений метод для перевірки об’єктів цього класу. (1 бал) 

    перевизначено у Staff 25 строка
    
    використовується у Concert 26 строка, метод ArrayList.contains() викликає equals() для перевірки наявності у списку
    
    ~~~
    Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that Objects.equals(o, e).
    ~~~

- присутня асоціація класів (1 бал) 

    клас Singer метод perform(Instrument instrument)
    
    між Singer та Instrument


Structure:

![Diagram](./diagram.png)