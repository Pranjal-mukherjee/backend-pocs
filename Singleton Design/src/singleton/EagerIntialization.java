package singleton;

public class EagerIntialization {
    private static EagerIntialization eagerIntialization = new EagerIntialization();

    private EagerIntialization() {
    }
    public static EagerIntialization getEagerIntialization(){
        return eagerIntialization;
    }
}
