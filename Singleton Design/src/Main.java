import singleton.EagerIntialization;
import singleton.LazyIntialization;

public class Main {
    public static void main(String[] args) {
        LazyIntialization lazyIntialization1 = LazyIntialization.getLazyInitialization();
        System.out.println(lazyIntialization1.hashCode());
        LazyIntialization lazyIntialization2= LazyIntialization.getLazyInitialization();
        System.out.println(lazyIntialization2.hashCode());
        EagerIntialization eagerIntialization = EagerIntialization.getEagerIntialization();
        System.out.println(eagerIntialization.hashCode());
    }
}