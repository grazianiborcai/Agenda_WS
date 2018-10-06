package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderSetterLChanged;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorOrderEnforceLChanged implements DeciActionTransVisitor<OrderInfo> {
	
	@Override public List<OrderInfo> executeTransformation(List<OrderInfo> recordInfos) {
		List<OrderInfo> resultRecords = new ArrayList<>();		
		
		for (OrderInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private OrderInfo enforce(OrderInfo recordInfo) {
		OrderInfo clonedInfo = makeClone(recordInfo);
		OrderSetterLChanged attrSetter = new OrderSetterLChanged();
		return attrSetter.setAttr(clonedInfo);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
