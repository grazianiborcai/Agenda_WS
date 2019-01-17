package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.info.InfoWritterFactory;

public final class OrderMerger extends InfoWritterFactory<OrderInfo> {	
	
	public OrderMerger() {
		super(new OrderUniquifier());
	}
	
	
	
	static public OrderInfo merge(SnapInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(CartSnapInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerCartSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public OrderInfo merge(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerUserSnap().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public OrderInfo merge(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {
		return new OrderMergerOrderStatus().merge(sourceOne, sourceTwo);
	}	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<OrderInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof SnapInfo 				&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CartSnapInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerCartSnap().merge((List<CartSnapInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UserSnapInfo 			&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerUserSnap().merge((List<UserSnapInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof OrderStatusInfo 		&&
			sourceTwos.get(0) instanceof OrderInfo		)
			return new OrderMergerOrderStatus().merge((List<OrderStatusInfo>) sourceOnes, (List<OrderInfo>) sourceTwos);
		
		return null;
	}
}
