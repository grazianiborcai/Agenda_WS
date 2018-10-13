package br.com.gda.business.order.model.action;

import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class MultiOrderVisitorMergeExtra extends ActionMultiVisitorTemplate<OrderInfo>{
	
	public MultiOrderVisitorMergeExtra() {
		super();
	}
	
	
	
	@Override protected List<OrderInfo> executeHook(int index, List<OrderInfo> infoRecords, boolean hasNext) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
}
