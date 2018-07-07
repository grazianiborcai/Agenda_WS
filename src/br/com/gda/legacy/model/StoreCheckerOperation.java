package br.com.gda.legacy.model;

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
	},
	
	DELETE {
		@Override protected StoreChecker getInstanceOfStoreChecker() {
			return new StoreCheckerDelete();
		}
	};
	
	abstract protected StoreChecker getInstanceOfStoreChecker();
}
