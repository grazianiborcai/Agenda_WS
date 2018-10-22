package br.com.gda.business.order.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderFlag;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class VisiOrderAddExtra extends ActionMultiVisitorTemplate<OrderInfo> {
	private List<OrderInfo> items;
	private List<OrderInfo> extras;
	
	
	public VisiOrderAddExtra() {
		super();
	}
	
	
	
	@Override protected boolean buildListHook(List<OrderInfo> infoRecords, boolean hasNext) {
		boolean token = super.NOT_TAKEN;
		
		if (token == super.NOT_TAKEN)
			token = buildItems(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildExtras(infoRecords);
		
		return token;
	}
	
	
	
	private boolean buildItems(List<OrderInfo> infoRecords) {
		if (isItem(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initItems();
		buildListItems(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isItem(List<OrderInfo> infoRecords) {
		for (OrderInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != OrderFlag.ITEM.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initItems() {
		items = new ArrayList<>();
	}
	
	
	
	private void buildListItems(List<OrderInfo> infoRecords) {
		items.addAll(infoRecords);
	}
	
	
	
	private boolean buildExtras(List<OrderInfo> infoRecords) {
		if (isExtra(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initExtras();
		buildListExtras(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isExtra(List<OrderInfo> infoRecords) {
		for (OrderInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != OrderFlag.EXTRA.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initExtras() {
		extras = new ArrayList<>();
	}
	
	
	
	private void buildListExtras(List<OrderInfo> infoRecords) {
		extras.addAll(infoRecords);
	}
	
	
	
	@Override protected List<OrderInfo> executeHook() {
		return addExtraToItem();
	}
	
	
	
	private List<OrderInfo> addExtraToItem() {
		checkList();
		return add();
	}
	
	
	
	private void checkList() {
		if (extras == null || extras.isEmpty())
			throw new IllegalStateException("extras" + SystemMessage.ACTION_NOT_INIT);
		
		if (items == null || items.isEmpty())
			throw new IllegalStateException("items" + SystemMessage.ACTION_NOT_INIT);
	}
	
	
	
	private List<OrderInfo> add() {
		List<OrderInfo> results = new ArrayList<>();
		results.addAll(items);
		results.addAll(extras);
		
		return results;
	}
}
