/*
 * $Id$
 *  Copyright (c) 2019 Pavilion Data Systems Corporation.
 *   All rights reserved.
 *
 *   THIS SOFTWARE CONTAINS  CONFIDENTIAL INFORMATION AND TRADE SECRETS OF
 *   PAVILION DATA SYSTEMS CORPORATION. USE, DISCLOSURE OR REPRODUCTION IS
 *   PROHIBITED WITHOUT THE  PRIOR EXPRESS  WRITTEN PERMISSION OF PAVILION
 *   DATA SYSTEMS CORPORATION.
 *
 *   The Licensed Software and Documentation are deemed to be commercial
 *   computer software as defined in FAR 12.212 and subject to restricted
 *   rights  as defined  in  FAR Section  52.227-19  "Commercial Computer
 *   Software -  Restricted  Rights" and DFARS  227.7202,  "Rights in
 *   Commercial  Computer  Software  or  Commercial  Computer Software
 *   Documentation", as applicable, and any successor regulations. Any use,
 *   modification, reproduction release, performance, display or disclosure
 *   of the Licensed Software and Documentation by the U.S. Government shall
 *   be solely in accordance with the terms of this Agreement.
 */
package com.job.register.dao;

import com.job.register.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Integer> {
   Exam findByPosition(String examName);
}
