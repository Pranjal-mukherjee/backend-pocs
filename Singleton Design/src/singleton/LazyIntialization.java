package singleton;

public class LazyIntialization {
    private static LazyIntialization lazyIntialization;

    //    It's private to prevent external code from creating new instances of this class directly.
    private LazyIntialization() {
    }

    public static LazyIntialization getLazyInitialization(){

        if(lazyIntialization == null)
        {
            synchronized (LazyIntialization.class){
                if(lazyIntialization == null)
                    lazyIntialization = new LazyIntialization();
            }

        }
        return  lazyIntialization;
    }

}
