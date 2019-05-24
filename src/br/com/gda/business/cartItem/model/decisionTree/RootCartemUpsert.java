package br.com.gda.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.LazyCartemMergeMat;
import br.com.gda.business.cartItem.model.action.LazyCartemNodeServiceL1;
import br.com.gda.business.cartItem.model.action.LazyCartemNodeUpsertdel;
import br.com.gda.business.cartItem.model.action.StdCartemEnforceLChanged;
import br.com.gda.business.cartItem.model.checker.CartemCheckCart;
import br.com.gda.business.cartItem.model.checker.CartemCheckLangu;
import br.com.gda.business.cartItem.model.checker.CartemCheckMat;
import br.com.gda.business.cartItem.model.checker.CartemCheckOwner;
import br.com.gda.business.cartItem.model.checker.CartemCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCartemUpsert extends DeciTreeWriteTemplate<CartemInfo> {
	
	public RootCartemUpsert(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartemCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckCart(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartemCheckMat(checkerOption);
		queue.add(checker);
		
		//TODO: verificar limite de itens no carrinho
		//TODO: verificar quantidade. Somente 1 para servico. Nao pode ser negativa para todos os casos
		//TODO: verificar valores negativos
		//TODO: verificar Ordem em aberto
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> enforceLChanged = new StdCartemEnforceLChanged(option);
		ActionLazy<CartemInfo> mergeMat = new LazyCartemMergeMat(option.conn, option.schemaName);
		ActionLazy<CartemInfo> nodeService = new LazyCartemNodeServiceL1(option.conn, option.schemaName);
		ActionLazy<CartemInfo> nodeUpsertdel = new LazyCartemNodeUpsertdel(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeService);
		mergeMat.addPostAction(nodeUpsertdel);
		
		return actions;
	}
}
