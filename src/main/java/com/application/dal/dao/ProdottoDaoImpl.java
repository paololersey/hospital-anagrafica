package com.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.application.business.BO.ProdottoBO;
import com.application.converter.ProdottoConverter;
import com.application.dal.entity.Prodotto;
import com.application.exception.ConverterException;
import com.application.exception.DaoException;
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
	public List<ProdottoBO> getAll() throws DaoException {
		
		List<Prodotto> prodottiList = new ArrayList<>();
		ArrayList<ProdottoBO> prodottoBOList = new ArrayList<ProdottoBO>();
		
		try {
			
			/* replace by Criteria*/
			
			prodottoBOList = new ArrayList<ProdottoBO>();
			String sqlQuery = "SELECT * FROM PRODOTTO";
			SQLQuery query = getCurrentSession().createSQLQuery(sqlQuery);
			query.addEntity(Prodotto.class);
			prodottiList = query.list();
			
			/* */
			
			for(Prodotto prodotto: prodottiList) {
				prodottoBOList.add(prodottoConverter.convertEntityToBO(prodotto));
			};

			
		} catch (ConverterException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate mapping exception");
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate generic exception = " + e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DaoException("Error in class " + className + ", method getByNomeProdotto, exception = " + e.getMessage());
		}
		
		return prodottoBOList;
	}
	

	private Session getCurrentSession() {
		return HibernateUtil.getCurrentSession();
	}


	@Override
	public ProdottoBO getByNomeProdotto(String nomeProdotto) throws DaoException {
	
		ProdottoBO prodottoBO = null;

			try {
				Prodotto prodotto = (Prodotto) getCurrentSession().createCriteria(Prodotto.class)
						.add(Restrictions.eq("nomeProdotto", nomeProdotto)).uniqueResult();
				prodottoBO = prodottoConverter.convertEntityToBO(prodotto);
			} catch (ConverterException e) {
				log.error(e.getMessage(), e);
				throw new DaoException("hibernate mapping exception");
			} catch (HibernateException e) {
				log.error(e.getMessage(), e);
				throw new DaoException("hibernate generic exception = " + e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DaoException("Error in class " + className + ", method getByNomeProdotto, exception = " + e.getMessage());
			}

			return prodottoBO;		
	}


	@Override
	public ProdottoBO getProdottoById(Long id) throws DaoException {
		ProdottoBO prodottoBO = null;

		try {
			Prodotto prodotto = (Prodotto) getCurrentSession().get(Prodotto.class, id);			
			prodottoBO = prodottoConverter.convertEntityToBO(prodotto);
		} catch (ConverterException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate mapping exception");
		} catch (HibernateException e) {
			log.error(e.getMessage(), e);
			throw new DaoException("hibernate generic exception = " + e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DaoException("Error in class " + className + ", method getProdottoById, exception = " + e.getMessage());
		}

		return prodottoBO;		
	}
	


}
