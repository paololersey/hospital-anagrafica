package com.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.application.business.BO.ContoBO;
import com.application.business.BO.ProdottoBO;
import com.application.converter.ProdottoConverter;
import com.application.dal.entity.Prodotto;
import com.application.util.HibernateUtil;

/** Data access object layer */

public class ProdottoDaoImpl implements ProdottoDao {

	private static String className = ProdottoDaoImpl.class.getName();
	
	@Inject
	private transient Logger log;

	@Inject
	private ProdottoConverter prodottoConverter;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdottoBO> getAll() throws Exception {

		try {
			
			/* replace by Criteria*/
			
			ArrayList<ProdottoBO> prodottoBOList = new ArrayList<ProdottoBO>();
			String sqlQuery = "SELECT * FROM PRODOTTO";
			SQLQuery query = getCurrentSession().createSQLQuery(sqlQuery);
			query.addEntity(Prodotto.class);
			List<Prodotto> prodottiList = query.list();
			
			/* */
			
			for(Prodotto prodotto: prodottiList) {
				prodottoBOList.add(prodottoConverter.convertEntityToBO(prodotto));
			};

			return prodottoBOList;
		} catch (MappingException me) {
			log.error(me);
			throw new HibernateException("hibernate mapping exception", me);
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Exception during get prodotto ", e);
		}
	}
	

	private Session getCurrentSession() {
		return HibernateUtil.getCurrentSession();
	}


	@Override
	public ProdottoBO getByNomeProdotto(String nomeProdotto) throws Exception {
	
		ProdottoBO prodottoBO = null;

			try {
				Prodotto prodotto = (Prodotto) getCurrentSession().createCriteria(Prodotto.class)
						.add(Restrictions.eq("nomeProdotto", nomeProdotto)).uniqueResult();
				prodottoBO = prodottoConverter.convertEntityToBO(prodotto);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new Exception("Error in class " + className + ", method getByNomeProdotto, exception" + e);
			}

			return prodottoBO;		
	}
	


}
