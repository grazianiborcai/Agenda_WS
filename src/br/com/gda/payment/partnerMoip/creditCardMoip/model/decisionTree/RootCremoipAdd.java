package br.com.gda.payment.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipAdd;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceAddress;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceCard;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceDocument;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceFunding;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceHolder;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforcePhone;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceSetup;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.action.StdCremoipMergeSetupar;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckAdd;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckAddressBR;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckAddressData;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckBirthdate;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckCusparData;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckPhoneBR;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckPhoneData;
import br.com.gda.payment.partnerMoip.creditCardMoip.model.checker.CremoipCheckSetupar;

public final class RootCremoipAdd extends DeciTreeWriteTemplate<CremoipInfo> {
	
	public RootCremoipAdd(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildDecisionCheckerHook(DeciTreeOption<CremoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CremoipCheckCusparData();
		queue.add(checker);
		
		checker = new CremoipCheckPhoneData();
		queue.add(checker);
		
		checker = new CremoipCheckAddressData();
		queue.add(checker);
		
		checker = new CremoipCheckAdd();
		queue.add(checker);
		
		checker = new CremoipCheckAddressBR();
		queue.add(checker);
		
		checker = new CremoipCheckPhoneBR();
		queue.add(checker);
		
		checker = new CremoipCheckBirthdate();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CremoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> mergeSetupar = new StdCremoipMergeSetupar(option);
		ActionLazy<CremoipInfo> enforceSetup = new LazyCremoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceAddress = new LazyCremoipEnforceAddress(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceDocument = new LazyCremoipEnforceDocument(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforcePhone = new LazyCremoipEnforcePhone(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceHolder = new LazyCremoipEnforceHolder(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceCard = new LazyCremoipEnforceCard(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceFunding = new LazyCremoipEnforceFunding(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> addCard = new LazyCremoipAdd(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(enforceSetup);
		enforceSetup.addPostAction(enforceAddress);
		enforceAddress.addPostAction(enforceDocument);
		enforceDocument.addPostAction(enforcePhone);
		enforcePhone.addPostAction(enforceHolder);
		enforceHolder.addPostAction(enforceCard);
		enforceCard.addPostAction(enforceFunding);
		enforceFunding.addPostAction(addCard);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
