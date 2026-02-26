public class ParserEx {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML");
        // Parseable 인터페이스의 parse를 구현한, 오버라이딩된 XMLParser 객체의 메서드 parse()가 실행
        parser.parse("document.xml");

        parser = ParserManager.getParser("HTML");
        // Parseable 인터페이스의 parse를 구현한, 오버라이딩된 HTMLParser 객체의 메서드 parse()가 실행
        parser.parse("document.html");
    }
}

interface Parseable {
    public abstract void parse(String fileName);
}

class ParserManager {
    // 리턴타입이 인터페이스 -> Parseable 인터페이스를 구현한 클래스의 인스턴스가 반환된다.
    public static Parseable getParser(String type) {
        if (type.equals("XML")) return new XMLParser();
        return new HTMLParser();
    }
}

class XMLParser implements Parseable {
    public void parse(String fileName) {
        System.out.println("Parsing XML file : " + fileName);
    }
}

class HTMLParser implements Parseable {
    public void parse(String fileName) {
        System.out.println("Parsing HTML file : " + fileName);
    }
}