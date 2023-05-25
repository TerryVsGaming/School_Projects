#pragma once

#include<string>
#include <sstream>
using namespace std;
#include "Student.h"

class Undergraduate:public Student
{
private:
  string standing;

public:
  Undergraduate (string initKey, string firstName, string lastName,
		 double initGPA, string initstanding):Student (initKey,
							       firstName,
							       lastName,
							       initGPA)
  {
    this->standing = initstanding;
  }

  string getStanding ()
  {
    return this->standing;
  }

  void setStanding (string initstanding)
  {
    this->standing = initstanding;
  }

  string toString ()
  {
    stringstream ss;		// like output stream
    // << = consume (output)    >> = produce (input)
    ss << this->getFirstName () << " " << this->getLastName () <<
      " (gpa: " << this->getGpa() << ", standing: " << this->standing << ")";
    return ss.str ();
  }
  
};
