package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.info.InfoWritterFactory;

public final class OrderMerger extends InfoWritterFactory<OrderInfo> {	
	
	public OrderMerger() {
		super(new OrderUniquifier());
	}
	
	
	
	static public OrderInfo merge(EmpInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerEmp().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(CusInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerCus().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(OrderInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerOrder().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(MatInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(StoreInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerStore().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerUserSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(UserInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<OrderInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof EmpInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerEmp().merge((List<EmpInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CusInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerCus().merge((List<CusInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof OrderInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerOrder().merge((List<OrderInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerMat().merge((List<MatInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof StoreInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerStore().merge((List<StoreInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UserSnapInfo 		&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerUserSnap().merge((List<UserSnapInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UserInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerUser().merge((List<UserInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		return null;
	}
}
