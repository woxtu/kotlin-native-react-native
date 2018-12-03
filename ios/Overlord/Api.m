#import "Api.h"
#import <React/RCTUtils.h>
#import <lib/lib.h>

@implementation Api

RCT_EXPORT_MODULE();

RCT_REMAP_METHOD(searchRepositories,
                 searchRepositoriesWithQuery:(NSString*)query
                 withPage:(NSInteger)page
                 withPerPage:(NSInteger)perPage
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejector:(RCTPromiseRejectBlock)reject)
{
  LibGitHubClient* client = [[LibGitHubClient alloc] init];
  [client searchRepositoriesQuery:query
                             page:(int32_t)page
                          perPage:(int32_t)perPage
                         callback:^(NSString* response, LibKotlinThrowable* e)
  {
    if (e != nil) {
      reject(RCTErrorUnspecified, e.message, RCTErrorWithMessage(e.message));
    } else {
      resolve(response);
    }
    
    return [LibKotlinUnit unit];
  }];
}

-(dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

@end
