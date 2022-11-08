package abstractFactory;

import abstractFactory.color.Black;
import abstractFactory.color.Color;
import abstractFactory.color.White;

public class ColorFactory implements AbstractFactory<Color> {
    @Override
    public Color create(String type) {
        if ("White".equalsIgnoreCase(type)) {
            return new White();
        }
        else if ("Black".equalsIgnoreCase(type)) {
            return new Black();
        }
        return null;
    }
}