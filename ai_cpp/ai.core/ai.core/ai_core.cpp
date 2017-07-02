/*
 *  ai_core.cpp
 *  ai.core
 *
 *  Created by Viktor Kuznietsov on 6/29/17.
 *  Copyright © 2017 Viktor Kuznietsov. All rights reserved.
 *
 */

#include <iostream>
#include "ai_core.hpp"
#include "ai_corePriv.hpp"

void ai_core::HelloWorld(const char * s)
{
    ai_corePriv *theObj = new ai_corePriv;
    theObj->HelloWorldPriv(s);
    delete theObj;
};

void ai_corePriv::HelloWorldPriv(const char * s) 
{
    std::cout << s << std::endl;
};

