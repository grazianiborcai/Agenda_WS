package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorOrderFirstRow implements DeciActionTransVisitor<OrderInfo> {
	
	@Override public List<OrderInfo> executeTransformation(List<OrderInfo> recordInfos) {
		List<OrderInfo> resultRecords = new ArrayList<>();		
		
		recordInfos.get(0);
		resultRecords.add(enforce(recordInfos.get(0)));		
		
		return resultRecords;
	}	
	
	
	
	private OrderInfo enforce(OrderInfo recordInfo) {
		return makeClone(recordInfo);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
