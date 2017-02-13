import { Component, AfterViewInit } from '@angular/core';

import { Title }     from '@angular/platform-browser';
import { ITdDataTableColumn } from '@covalent/core';
import { TdLoadingService } from '@covalent/core';

import { ItemsService, UsersService, ProductsService, AlertsService } from '../../services';

import { multi } from './data';
import { Response, Http, Headers } from '@angular/http';
import { RESTService, HttpInterceptorService } from '@covalent/http';


@Component({
  selector: 'qs-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
  viewProviders: [ ItemsService, UsersService, ProductsService, AlertsService ]
})
export class DashboardComponent{
 constructor(
            private _UsersService:UsersService){}
            public userDetail:any[]=this.getAllUser();
                       columns: ITdDataTableColumn[] = [
    { name: 'id', label: 'ID', tooltip: 'Stock Keeping Unit' },
    { name: 'name', label: 'NAME' },
    { name: 'email', label :'EMAIL ID', numeric: true},
  ];

clickForDelete(row:any):any
{
 this._UsersService.deleteUser(row['id']).subscribe((users: any) => {
       console.log("DATA = ="+ users);
      this.getAllUser();
 });

  console.log(row['id']);
}
public editFlag = false;
public idForEdit='';
public n='';
public e='';
clickForEdit(row:any):any
{
  this.addFlag = false;
  this.editFlag=true;
  this.idForEdit=row['id'];
  
  console.log(row['id']);
  this.n = row['name'];
  this.e=row['email'];
}
public addFlag = false;
addUser(){
      this.editFlag = false;
      this.addFlag = true;
      console.log(this.addFlag);
  
}

getAllUser():any
{
 this._UsersService.getAllUser().subscribe((users: any) => {
       console.log("DATA = ="+ users);
      this.userDetail = users;
 });
      this.editFlag = false;
      this.addFlag = false;
}

onUpdate(name:string,email:string)
{
      
      console.log('name:'+this.n);        
          this.data=JSON.stringify({"id":'',"name":name,"email":email}); 
      this._UsersService.doUpdate(this.idForEdit,this.data).subscribe((users:any) => {
       console.log("DATA = ="+ users);
       alert('person is updated into table successfully');
       this.getAllUser();
 });

 
}

public data:any;
onSubmit(n:string,e:string):any
{
  this.data=JSON.stringify({"id":"","name":n,"email":e});
  this._UsersService.doPost(this.data).subscribe((res) => {
            alert('person is added into table  successfully');
       this.getAllUser();
 });
  
}

}


