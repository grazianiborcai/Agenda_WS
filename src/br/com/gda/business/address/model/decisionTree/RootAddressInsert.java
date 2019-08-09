package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressEnforceLChanged;
import br.com.gda.business.address.model.action.LazymapAddressNodeInsert;
import br.com.gda.business.address.model.action.MapAddressMergeForm;
import br.com.gda.business.address.model.checker.AddressCheckCountry;
import br.com.gda.business.address.model.checker.AddressCheckRefMulti;
import br.com.gda.business.address.model.checker.AddressCheckRefWrite;
import br.com.gda.business.address.model.checker.AddressCheckTechField;
import br.com.gda.business.address.model.checker.AddressCheckInsert;
import br.com.gda.business.address.model.checker.AddressCheckLimit;
import br.com.gda.business.address.model.checker.AddressCheckOwner;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAddressInsert extends DeciTreeWriteTemplate<AddressInfo> {
	
	public RootAddressInsert(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildDecisionCheckerHook(DeciTreeOption<AddressInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new AddressCheckInsert();
		queue.add(checker);
		
		checker = new AddressCheckTechField();
		queue.add(checker);
		
		checker = new AddressCheckRefWrite();
		queue.add(checker);
		
		checker = new AddressCheckRefMulti();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new AddressCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new AddressCheckCountry(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checker = new AddressCheckLimit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddressInfo> mergeForm = new MapAddressMergeForm(option);		
		ActionLazy<AddressInfo> enforceLChanged = new LazyAddressEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> nodeInsert = new LazymapAddressNodeInsert(option.conn, option.schemaName);	
		
		mergeForm.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodeInsert);
		
		actions.add(mergeForm);		
		return actions;
	}
}
