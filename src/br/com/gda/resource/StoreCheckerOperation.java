package br.com.gda.resource;

public enum StoreCheckerOperation {
	UPDATE {
		@Override protected StoreChecker getInstanceOfStoreChecker() {
			return new StoreCheckerUpdate();
		}
	},
	
	INSERT {
		@Override protected StoreChecker getInstanceOfStoreChecker() {
			return new StoreCheckerInsert();
		}
	};
	
	abstract protected StoreChecker getInstanceOfStoreChecker();
}
