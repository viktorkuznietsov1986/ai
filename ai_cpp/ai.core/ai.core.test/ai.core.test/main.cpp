//
//  main.cpp
//  ai.core.test
//
//  Created by Viktor Kuznietsov on 6/29/17.
//  Copyright © 2017 Viktor Kuznietsov. All rights reserved.
//

#include <iostream>
#include "../../ai.core/ai_core.hpp"


int main(int argc, const char * argv[]) {
    // insert code here...
    //std::cout << "Hello, World!\n";
    
    auto a = new ai_core();
    a->HelloWorld("test123");
    
    delete a;
    
    return 0;
}
